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
import com.google.gwt.user.client.DOM;
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
	private static Map<String, String> params = new HashMap<>();
	private TextBox inputBuscar;

	/**
	 * This is the entry point method.
	 */
	
	public void onModuleLoad() {
		showInicio();
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
			RootPanel.get("formCont").addStyleName("hidden");
			RootPanel.get("busquedaCont").addStyleName("hidden");
			RootPanel.get("form").clear();
			RootPanel.get("botonBuscar").clear();
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
			RootPanel.get("botonBuscar").clear();
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

				if (result.getResults().getDeck()!=null)
					output ="Description: <br>"+result.getResults().getDeck();
				else
					output = "Description: <br> No description";
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
				
				
				output = "Juegos Similares:";
				res = new HTML(output);
				RootPanel.get("similar").add(res);
				
				List<Similar_game> juegosSimilares = result.getResults().getSimilar_games();
				int n = juegosSimilares.size()>10 ? 10 : juegosSimilares.size();
				for(i=0; i<n; i++){
					final Similar_game g = juegosSimilares.get(i);
					Button similar = new Button(g.getName());
					similar.addClickHandler(new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							params.put("idGB", g.getId()+"");
							params.put("juego", g.getName());
							controlador("principal");
						}
					});
					similar.setStyleName("juegosSimilares");
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
				
				/* *********************** */
				
				Integer id = appMap.get(params.get("juego").toLowerCase());
				if (id!=null) {
					greetingService.getSteamPrice(id,new AsyncCallback<Double>(){

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
						}
							@Override
						public void onSuccess(Double result) {
							// TODO Auto-generated method stub
								String output = "";
								
								if(!result.equals(null)){		
										
									output += "<p> Steam Price:<br>" +result + " &#128;</p>";
									
								}
								HTML res = new HTML(output);
								final HorizontalPanel panel2= new HorizontalPanel();
								panel2.add(res);
								RootPanel.get("SteamPrice").add(panel2);
						}
						
					});
				} else {
					output = "<p> Steam Price:<br> Unavailable </p>";
					res = new HTML(output);
					final HorizontalPanel panel2= new HorizontalPanel();
					panel2.add(res);
					RootPanel.get("SteamPrice").add(panel2);
				}
					
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
		RootPanel.get("formCont").removeStyleName("hidden");
		RootPanel.get("busquedaCont").removeStyleName("hidden");
		
		inputBuscar = new TextBox();
		
		inputBuscar.setStyleName("buscador");	
		inputBuscar.getElement().setPropertyString("placeholder", "Game to search");
		inputBuscar.getElement().setId("inputBuscador");
		inputBuscar.addKeyUpHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode()==KeyCodes.KEY_ENTER){
					params.put("juego", inputBuscar.getText());
					controlador("busqueda");
				}
			}
		});

		Button boton = getBotonSend(inputBuscar);
		
		RootPanel.get("form").add(inputBuscar);
		RootPanel.get("botonBuscar").add(boton);
		inputBuscar.setFocus(true);
		inputBuscar.selectAll();
	}


	private Button getBotonSend(final TextBox buscador) {
		final Button res = new Button("Send");

		res.setStyleName("sendButton");
		res.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				params.put("juego", buscador.getText());
				controlador("busqueda");
			}
		});
		
		return res;
	}




	private void showBusqueda() {
		RootPanel.get("formCont").removeStyleName("hidden");
		RootPanel.get("busquedaCont").removeStyleName("hidden");
		final String juego= params.get("juego");
		HTML carga = new HTML("<img src='cargando.gif' height = '32'></img>");
		RootPanel.get("botonBuscar").clear();
		RootPanel.get("botonBuscar").add(carga);
		inputBuscar.getElement().setAttribute("disabled", "disabled");
		greetingService.getGiantBomb(juego, new AsyncCallback<GiantBombSearch>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(GiantBombSearch result) {
				
				Button boton = getBotonSend(inputBuscar);
				RootPanel.get("botonBuscar").clear();
				RootPanel.get("botonBuscar").add(boton);
				inputBuscar.getElement().removeAttribute("disabled");
				inputBuscar.selectAll();
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
					if (r.getDeck()!=null)
						output = "<div class='busq'>" +r.getDeck()+ "</div>";
					else
						output = "<div class='busq'> No description </div>";
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
