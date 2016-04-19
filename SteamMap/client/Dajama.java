package dajama.client;

import java.util.HashMap;
import java.util.Map;

import dajama.shared.domain.giantBomb.GiantBomb;
import dajama.shared.domain.giantBomb.Result;
import dajama.shared.domain.steam.App;
import dajama.shared.domain.steam.SteamID;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Dajama implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private final Map<String, Integer> appMap = getIdMapSteam();
	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		final Button boton = new Button("Send");
		final TextBox buscador = new TextBox();
		final HorizontalPanel panel = new HorizontalPanel();
		buscador.setText("Juego a buscar");

		boton.addStyleName("sendButton");

		panel.add(buscador);
		panel.add(boton);
		
		RootPanel.get("form").add(panel);

		buscador.setFocus(true);
		buscador.selectAll();
		
		boton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final String juego = buscador.getText();

				RootPanel.get("giantBomb").clear();
				
				greetingService.getGiantBomb(juego, new AsyncCallback<GiantBomb>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						HTML res = new HTML(juego);
						
						RootPanel.get().add(res);
					}

					@Override
					public void onSuccess(GiantBomb result) {
						// TODO Auto-generated method stub
						showGiantBomb(juego, result);
					}
					
				});

			}
		});


	}
	
	private void showGiantBomb(String juego, GiantBomb result){
		String output = "<fieldset>";
		output += "<legend>" + juego + " GiantBomb</legend>";
		
		if(!result.getResults().isEmpty()){
			
			for(Result r: result.getResults()){
				
			output += "<p>" +r.getName() + "</p>";

			output += "<img  width='500' heigth='500' src=" +r.getImage().getSmall_url()+ "></img>";

			output += "<span>  IdSteam: " + appMap.get(r.getName().toLowerCase()) + "</span>";
			}
		}else{
			output="<span> No results </span>";
		}
		output += "</fieldset>";
		HTML res = new HTML(output);
		final HorizontalPanel panel2= new HorizontalPanel();
		panel2.add(res);
		RootPanel.get("giantBomb").add(panel2);
	}
	
	
	private Map<String, Integer> getIdMapSteam(){
		final Map<String, Integer> idMap = new HashMap<String,Integer>();
		greetingService.getSteamID(new AsyncCallback<SteamID>() {
			
			@Override
			public void onSuccess(SteamID result) {
				for (App a : result.getApplist().getApps()){
					idMap.put(a.getName().toLowerCase(), a.getAppid());
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
		return idMap;
	}
}
