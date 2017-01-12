package dev.ryanandcale.rpggame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.ryanandcale.rpggame.Game;
import dev.ryanandcale.rpggame.Handler;
import dev.ryanandcale.rpggame.gfx.Assets;
import dev.ryanandcale.rpggame.ui.ClickListener;
import dev.ryanandcale.rpggame.ui.UIImageButton;
import dev.ryanandcale.rpggame.ui.UIManager;

public class MenuState extends State{
	
	private UIManager uiManager;
	
	public MenuState(Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener(){

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null); //clear the mouse manager when you enter into the game
				State.setState(handler.getGame().gameState);
				
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
		
	}
	

}
