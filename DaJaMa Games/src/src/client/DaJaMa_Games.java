package src.client;

import src.shared.domain.giantBomb.GiantBomb;
import src.shared.domain.giantBomb.Result;
import src.shared.domain.steam.App;
import src.shared.domain.steam.SteamID;

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
public class DaJaMa_Games implements EntryPoint {
	
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
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
					}

					@Override
					public void onSuccess(GiantBomb result) {
						// TODO Auto-generated method stub
						showGiantBomb(juego, result);
					}
					
				});
				
				greetingService.getSteamID(new AsyncCallback<SteamID>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
					}

					@Override
					public void onSuccess(SteamID result) {
						// TODO Auto-generated method stub
						Integer abc=0;
						for(App a: result.getApplist().getApps().getApp()){
							if(a.getName().equalsIgnoreCase(juego)){
								abc=a.getAppid();
							}
						}
						greetingService.getSteamPrice(abc,new AsyncCallback<Double>(){

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
							}

							@Override
							public void onSuccess(Double result) {
								// TODO Auto-generated method stub
								showSteamPrice(juego, result);
							}
							
						});
					}
					
				});
			}
		});


	}
	
	
	private void showGiantBomb(String juego, GiantBomb result){
		String output = "<fieldset>";
		output += "<legend>" + juego + " GiantBomb</legend>";
		
		if(!result.getResults().isEmpty()){
			
			Result r = result.getResults().get(0);

			output += "<img  width='500' heigth='500' src=" +r.getImage().getSmall_url()+ "></img>";

			
		}else{
			output="<span> No results </span>";
		}
		output += "</fieldset>";
		HTML res = new HTML(output);
		final HorizontalPanel panel2= new HorizontalPanel();
		panel2.add(res);
		RootPanel.get("giantBomb").add(panel2);
	}
	
	private void showSteamPrice(String juego,Double result){
		String output = "<fieldset>";
		output += "<legend>Precio " + juego + " en Steam</legend>";
		
		if(result!=null){		
				
			output += "<p>" +result + " €</p>";
			
		}else{
			output="<span> No results </span>";
		}
		output += "</fieldset>";
		HTML res = new HTML(output);
		final HorizontalPanel panel2= new HorizontalPanel();
		panel2.add(res);
		RootPanel.get("SteamPrice").add(panel2);
	}
	
}
