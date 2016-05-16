package src.client;

import java.util.HashMap;
import java.util.Map;

import src.shared.domain.giantBomb.GiantBomb;
import src.shared.domain.giantBomb.Platform;
import src.shared.domain.giantBomb.Result;
import src.shared.domain.steam.App;
import src.shared.domain.steam.SteamID;
import src.shared.domain.youtube.Item;
import src.shared.domain.youtube.YoutubeSearch;

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
	
	private final Map<String, Integer> appMap = getIdMapSteam();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button boton = new Button("Send");
		final TextBox buscador = new TextBox();
		buscador.setStyleName("buscador");
		final HorizontalPanel panel = new HorizontalPanel();
		buscador.setText("Game to search");

		boton.addStyleName("sendButton");

		panel.add(buscador);
		panel.add(boton);
		
		RootPanel.get("form").add(panel);

		buscador.setFocus(true);
		buscador.selectAll();
		
		boton.setStyleName("boton");
		
		boton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				final String juego = buscador.getText();

				RootPanel.get("giantBomb").clear();
				RootPanel.get("youtube").clear();
				RootPanel.get("SteamPrice").clear();
				RootPanel.get("nombreGB").clear();
				RootPanel.get("descripcion").clear();
				
				greetingService.getYoutubeSearch(juego, new AsyncCallback<YoutubeSearch>(){

					@Override
					public void onFailure(Throwable caught) {
						HTML res = new HTML(caught.getMessage());
						RootPanel.get("youtube").add(res);
						
					}

					@Override
					public void onSuccess(YoutubeSearch result) {
						showYoutubeSearch(juego,result);
						
					}
					
				});
				
				
				greetingService.getGiantBomb(juego, new AsyncCallback<GiantBomb>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
					}

					@Override
					public void onSuccess(GiantBomb result) {
						// TODO Auto-generated method stub
						showGiantBomb(juego, result);
						Integer id = appMap.get(result.getResults().get(0).getName().toLowerCase());
						greetingService.getSteamPrice(id,new AsyncCallback<Double>(){

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
		String output = "";
		String output2 = "";
		String descripcion = "";
		
		if(!result.getResults().isEmpty()){
			
			Result r = result.getResults().get(0);
			output2 +="<span id='titulo'>" + r.getName() + "</span>";
			output += "<br><img  width='250' heigth='250' src=" +r.getImage().getSmall_url()+ "></img>";
			output += "<br>Plataformas: ";
			descripcion = r.getDeck();
			int i=0;
			
			for(Platform p : r.getPlatforms()){
				if(r.getPlatforms().size()-1 != i)
				 output += p.getAbbreviation() + ", ";
				else
					output +=p.getAbbreviation();
				i++;
			}
		}else{
			output="<span> No results </span>";
		}
		HTML res = new HTML(output);
		final HorizontalPanel panel2= new HorizontalPanel();
		panel2.add(res);
		RootPanel.get("giantBomb").add(panel2);
		HTML res2 = new HTML(output2);
		final HorizontalPanel panel3 = new HorizontalPanel();
		panel3.add(res2);
		RootPanel.get("nombreGB").add(panel3);
		HTML res3 = new HTML(descripcion);
		final HorizontalPanel panel4 = new HorizontalPanel();
		panel4.add(res3);
		RootPanel.get("descripcion").add(panel4);
		}
	
	private void showSteamPrice(String juego,Double result){
		String output = "";
		
		if(result!=null){		
				
			output += "<p> Precio del juego en Steam:<br>" +result + " &#128;</p>";
			
		}else{
			output="<span> No results </span>";
		}
		HTML res = new HTML(output);
		final HorizontalPanel panel2= new HorizontalPanel();
		panel2.add(res);
		RootPanel.get("nombreGB").add(panel2);
	}
	
	private void showYoutubeSearch(String juego, YoutubeSearch result){
		String output = "";
		if(!result.getItems().isEmpty()){
			for(Item r : result.getItems()){
				//output += "<p>" + r.getSnippet().getTitle() + "</p>";
				output += "<p><iframe src=https://www.youtube.com/embed/"+r.getId().getVideoId()+" fs=1 allowfullscreen webkitallowfullscreen mozallowfullscreen></iframe></p>";
				
			}
		}else{
			output = "<span> No results </span>";
		}
		HTML res = new HTML(output);
		final HorizontalPanel panel3 = new HorizontalPanel();
		panel3.add(res);
		RootPanel.get("youtube").add(panel3);
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
