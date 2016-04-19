package dajama.client;

import java.util.Iterator;

import dajama.shared.domain.youtube.Item;
import dajama.shared.domain.youtube.YoutubeSearch;
import dajama.shared.domain.giantBomb.GiantBomb;
import dajama.shared.domain.giantBomb.Result;

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
import com.google.gwt.user.client.ui.VerticalPanel;

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
				RootPanel.get("youtube").clear();
				
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
	private void showYoutubeSearch(String juego, YoutubeSearch result){
		String output = "<fieldset>";
		output += "<legend>" + juego + " Youtube</legend>";
		if(!result.getItems().isEmpty()){
			for(Item r : result.getItems()){
				output += "<p>" + r.getSnippet().getTitle() + "</p>";
				output += "<iframe src=https://www.youtube.com/embed/"+r.getId().getVideoId()+" fs=1 allowfullscreen webkitallowfullscreen mozallowfullscreen></iframe>";
				
			}
		}else{
			output = "<span> No results </span>";
		}
		output += "</fieldset>";
		HTML res = new HTML(output);
		final HorizontalPanel panel3 = new HorizontalPanel();
		panel3.add(res);
		RootPanel.get("youtube").add(panel3);
	}
	
	private void showGiantBomb(String juego, GiantBomb result){
		String output = "<fieldset>";
		output += "<legend>" + juego + " GiantBomb</legend>";
		
		if(!result.getResults().isEmpty()){
			
			for(Result r: result.getResults()){
				
			output += "<p>" +r.getName() + "</p>";

			output += "<img  width='500' heigth='500' src=" +r.getImage().getSmall_url()+ "></img>";

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
	
}
