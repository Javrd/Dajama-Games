package src.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.shared.domain.giantBomb.Genre;
import src.shared.domain.giantBomb.GiantBombSearch;
import src.shared.domain.giantBomb.GiantBombGame;
import src.shared.domain.giantBomb.Image_;
import src.shared.domain.giantBomb.Platform;
import src.shared.domain.giantBomb.Result;
import src.shared.domain.giantBomb.Similar_game;
import src.shared.domain.steam.App;
import src.shared.domain.steam.SteamID;
import src.shared.domain.youtube.Item;
import src.shared.domain.youtube.YoutubeSearch;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DaJaMa_Games implements EntryPoint {
	
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	private final Map<String, Integer> appMap = getIdMapSteam();
	private static Map<String, String> params = new HashMap<>();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		final Button botonCabecera = new Button("DaJaMa Games");
		botonCabecera.setStyleName("gwt-HeaderButton");
		botonCabecera.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				controlador("inicio");
				
			}
		});
		final HorizontalPanel panel = new HorizontalPanel();
		panel.add(botonCabecera);
		RootPanel.get("head").add(panel);
		showInicio();
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
	
	private void controlador(String token){
		if(token=="busqueda"){
			RootPanel.get("busquedaCont").clear();
			RootPanel.get("giantBomb").clear();
			RootPanel.get("nombreGB").clear();
			RootPanel.get("SteamPrice").clear();
			RootPanel.get("descripcion").clear();
			RootPanel.get("plat").clear();
			RootPanel.get("genres").clear();
			RootPanel.get("similar").clear();
			RootPanel.get("slider").clear();
			RootPanel.get("youtube").clear();
			showBusqueda();
		}else if(token=="principal"){
			RootPanel.get("form").clear();
			RootPanel.get("busquedaCont").clear();
			RootPanel.get("giantBomb").clear();
			RootPanel.get("nombreGB").clear();
			RootPanel.get("SteamPrice").clear();
			RootPanel.get("descripcion").clear();
			RootPanel.get("plat").clear();
			RootPanel.get("genres").clear();
			RootPanel.get("similar").clear();
			RootPanel.get("slider").clear();
			RootPanel.get("youtube").clear();
			showPrincipal();
		}else if(token=="inicio"){
			RootPanel.get("form").clear();
			RootPanel.get("busquedaCont").clear();
			RootPanel.get("giantBomb").clear();
			RootPanel.get("nombreGB").clear();
			RootPanel.get("SteamPrice").clear();
			RootPanel.get("descripcion").clear();
			RootPanel.get("plat").clear();
			RootPanel.get("genres").clear();
			RootPanel.get("similar").clear();
			RootPanel.get("slider").clear();
			RootPanel.get("youtube").clear();
			showInicio();
			
		}
	}
	
	private void showPrincipal() {
		
		final Integer idGB = Integer.parseInt(params.get("idGB"));
		
		greetingService.getGiantBombGame(idGB, new AsyncCallback<GiantBombGame>(){
			//cambiar a otra llamada
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(GiantBombGame result) {
				// TODO Auto-generated method stub
				params.put("juego", result.getResults().getName());
				String output ="<h1>"+params.get("juego")+"</h1>";
				HTML res = new HTML(output);
				HorizontalPanel panel= new HorizontalPanel();
				panel.add(res);
				RootPanel.get("nombreGB").add(panel);								
				
				output ="<img width=200 height=231.33 src="+result.getResults().getImage().getMedium_url()+"></img>";
				res = new HTML(output);
				panel= new HorizontalPanel();
				panel.add(res);
				RootPanel.get("giantBomb").add(panel);	
				
				output ="Description: <br>"+result.getResults().getDeck();
				res = new HTML(output);
				panel= new HorizontalPanel();
				panel.add(res);
				RootPanel.get("descripcion").add(panel);
				
				output="Platforms:<br>";
				int i = result.getResults().getPlatforms().size();
				for(Platform p: result.getResults().getPlatforms()){
					output +=p.getName().toString();
					if(i!=1){
						output+=", ";
					}
					i--;
				}
				res = new HTML(output);
				panel= new HorizontalPanel();
				panel.add(res);
				RootPanel.get("plat").add(panel);	
				
				output="Genres: <br>";
				i = result.getResults().getGenres().size();
				for(Genre g: result.getResults().getGenres()){
					output +=g.getName();
					if(i!=1){
						output+=", ";
					}
					i--;
				}				
				res = new HTML(output);
				panel= new HorizontalPanel();
				panel.add(res);
				RootPanel.get("genres").add(panel);	
				
				for(final Similar_game g: result.getResults().getSimilar_games()){
					final Button similar = new Button(g.getName());
					similar.addStyleName("list-group-item");
					similar.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							params.put("idGB", g.getId()+"");
							params.put("juego", g.getName());
							controlador("principal");
							
						}
					});
					RootPanel.get("similar").add(similar);
				}
				
				/* Carousel Bootstrap */

				output = "<div id='gameImages' class='carousel slide' data-ride='carousel'>";
				
					output += "<div class='carousel-inner' role='listbox'>";
						List<Image_> listaImagenes = result.getResults().getImages();
						Boolean primero = true;
						for(Image_ imagenc: listaImagenes){
							if (primero){
								output += "<div class='item active'>";
								primero = false;
							} else {
								output += "<div class='item'>";
							}
							output +="<img class='img-responsive center-block' src='"+ imagenc.getMedium_url() +"'></img>";		
							output += "</div>";	
						}

					output += "</div>";
				
				output += "<a class='left carousel-control' href='#gameImages' role='button' data-slide='prev'>";
				output += "<span class='glyphicon glyphicon-chevron-left' aria-hidden='true'></span>";
				output += "<span class='sr-only'>Previous</span>";
				output += "</a>";
				output += "<a class='right carousel-control' href='#gameImages' role='button' data-slide='next'>";
				output += "<span class='glyphicon glyphicon-chevron-right' aria-hidden='true'></span>";
				output += "<span class='sr-only'>Next</span>";
				output += "</a>";

				output += "</div>";
				
				res = new HTML(output);
				RootPanel.get("slider").add(res);
				
				/*************************/
				Integer id = appMap.get(params.get("juego").toLowerCase());
				greetingService.getSteamPrice(id,new AsyncCallback<Double>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
					}
						@Override
					public void onSuccess(Double result) {
						// TODO Auto-generated method stub
							String output = "";
							
							if(result!=null){		
									
								output += "<p> Precio del juego en Steam:<br>" +result + " &#128;</p>";
								
							}else{
								output="<span> No results </span>";
							}
							HTML res = new HTML(output);
							final HorizontalPanel panel2= new HorizontalPanel();
							panel2.add(res);
							RootPanel.get("SteamPrice").add(panel2);
					}
					
				});
			}
			
		});
		
		greetingService.getYoutubeSearch(params.get("juego"), new AsyncCallback<YoutubeSearch>(){
			
			@Override
			public void onFailure(Throwable caught) {
				HTML res = new HTML(caught.getMessage());
				RootPanel.get("youtube").add(res);
				
			}

			@Override
			public void onSuccess(YoutubeSearch result) {
				String output = "";
				if(!result.getItems().isEmpty()){
					for(Item r : result.getItems()){
						output += "<p>" + r.getSnippet().getTitle() + "</p>";
						output += "<iframe width='480' height='270' src=https://www.youtube.com/embed/"+r.getId().getVideoId()+" fs=1 allowfullscreen webkitallowfullscreen mozallowfullscreen></iframe>";
						
					}
				}else{
					output = "<span> No results </span>";
				}
				HTML res = new HTML(output);
				final HorizontalPanel panel3 = new HorizontalPanel();
				panel3.add(res);
				RootPanel.get("youtube").add(panel3);
				
			}
			
		});
		
	}


	private void showInicio() {
		final Button boton = new Button("Send");
		final TextBox buscador = new TextBox();
		buscador.setStyleName("buscador");
		final HorizontalPanel panel = new HorizontalPanel();
		buscador.getElement().setPropertyString("placeholder", "Game to search");

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
				params.put("juego", buscador.getText());
				controlador("busqueda");
			}
		});
		buscador.addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode()==KeyCodes.KEY_ENTER){
					params.put("juego", buscador.getText());
					controlador("busqueda");
				}
			}
		});
		
	}


	private void showBusqueda() {
		final String juego= params.get("juego");
		greetingService.getGiantBomb(juego, new AsyncCallback<GiantBombSearch>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(GiantBombSearch result) {
				// TODO Auto-generated method stub
				String output = "";
				HTML res;
				if(!result.getResults().isEmpty()){
					for(final Result r: result.getResults()){

					HorizontalPanel panel1= new HorizontalPanel();
					HorizontalPanel panel2= new HorizontalPanel();
					Button boton2 = new Button(r.getName());
					boton2.setStyleName("tituloBusqueda");
					boton2.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub
							params.put("idGB", r.getId()+"");
							controlador("principal");
							
						}
					});
					output = "<div class='busq'>" +r.getDeck()+ "</div>";
					res = new HTML(output);				
					panel1.add(boton2);
					panel2.add(res);

					RootPanel.get("busquedaCont").add(panel1);
					RootPanel.get("busquedaCont").add(panel2);
					}
				}else{
					output="<span> No results </span>";
					res = new HTML(output);
					final HorizontalPanel panel2= new HorizontalPanel();
					panel2.add(res);
					RootPanel.get("busquedaCont").add(panel2);
				}
			}
		});
		
	}

}
