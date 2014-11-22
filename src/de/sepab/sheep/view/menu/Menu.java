package de.sepab.sheep.view.menu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Menu implements IMenu{
	private static JFrame jf = new JFrame ("ShEeP version 0.0.0"); // das Fenster
	// alle menue screens
	public static JLabel lMainMenu = new JLabel(), 
						 lSinglePlayer = new JLabel(), 
						 lMultiPlayer = new JLabel(), 
						 lHighscore = new JLabel(), 
						 lOptions = new JLabel(),
						 lHelp = new JLabel();
	//alle buttons
	public static JButton mmbSinglePlayer = new JButton("Einzelspieler"), //mm = mainmenu & b=button
						  	mmbMultiPlayer = new JButton("Mehrspieler"),
						  	mmbOption = new JButton("Option"),
						  	mmbHighscore = new JButton("Highscore"),
						  	mmbHelp = new JButton("Hilfe"),
						  	mmbExit = new JButton("Beenden"),
						  	
						  spbStart = new JButton("Start"), //sp = singleplayer
						  	spbBack = new JButton("Zurück"),
						  	
						  hsbback = new JButton("Zurück"), //hs = highscore
						  
						  obMinus = new JButton("-"),//o = options
						  	obPlus = new JButton("+"),
						  	obBack = new JButton("Zurück");
	//alle textfields
	public static JTextField sptfSingleplayer = new JTextField("Einzelspieler"),//tf = textfield
							 	sptfMap = new JTextField("Karte:"),
							 	sptfdifficulty = new JTextField("Schwierigkeit:"),
							 	sptfName = new JTextField("Name :"),
							 	sptfNameField = new JTextField(),
							 	sptfModus = new JTextField("Modus"),
							 	
							 mptfMultiplayer = new JTextField("Mehrspieler"),// mp = multiplayer
							 	mptfMap = new JTextField("Karte:"),
							 	
							 hstfHighscore = new JTextField("Highscore"),
							 	hstfOnTime = new JTextField("Auf Zeit:"),
							 	hstfOTplayer1 = new JTextField(),
							 	hstfOTplayer2 = new JTextField(),
							 	hstfOTplayer3 = new JTextField(),
							 	hstfOTplayer1points = new JTextField(),
								hstfOTplayer2points = new JTextField(),
								hstfOTplayer3points = new JTextField(),
								hstfOnNumber = new JTextField("Auf Anzahl:"),
								hstfONplayer1 = new JTextField(),
								hstfONplayer2 = new JTextField(),
								hstfONplayer3 = new JTextField(),
								hstfONplayer1points = new JTextField(),
								hstfONplayer2points = new JTextField(),
								hstfONplayer3points = new JTextField(),
							
							otfOptions = new JTextField("Optionen"),
								otfMusic = new JTextField("Musik:"),
								otfMusicField = new JTextField("50"),
								
							htfHelp = new JTextField("Hilfe"); //h = help
	//alle textareas
	public static JTextArea htaHelp = new JTextArea();
	//alle fonts
	public static Font basicFont = new Font(Font.DIALOG, Font.PLAIN, 12),
					   headingFont = new Font(Font.DIALOG, Font.BOLD, 24);
	
	
	//Methode zum swtichen der screens
	public static void setCurrentLabel(JLabel label) {
		lMainMenu.setVisible(false);
		lHelp.setVisible(false);
		lHighscore.setVisible(false);
		lMultiPlayer.setVisible(false);
		lOptions.setVisible(false);
		lSinglePlayer.setVisible(false);
		label.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		jf.setFocusable(false);
		jf.setSize(640, 480); //größe des screens
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		{//alle Font Deklarationen
			{//alle Button Fonts
				mmbSinglePlayer.setFont(basicFont);
			  	mmbMultiPlayer.setFont(basicFont);
			  	mmbOption.setFont(basicFont);
			  	mmbHighscore.setFont(basicFont);
			  	mmbHelp.setFont(basicFont);
			  	mmbExit.setFont(basicFont);
			  	
			  	spbStart.setFont(basicFont);
			  	spbBack.setFont(basicFont);
			  	
			  	hsbback.setFont(basicFont);
			  	
			    obMinus.setFont(basicFont);
			  	obPlus.setFont(basicFont);
			  	
			  	obBack.setFont(basicFont);
			}
			
			{//alle tf Fonts
				sptfSingleplayer.setFont(headingFont);
			 	sptfMap.setFont(basicFont);
			 	sptfdifficulty.setFont(basicFont);
			 	sptfName.setFont(basicFont);
			 	sptfNameField.setFont(basicFont);
			 	sptfModus.setFont(basicFont);
			 	
			 	mptfMultiplayer.setFont(headingFont);
			 	mptfMap.setFont(basicFont);
			 	
			 	hstfHighscore.setFont(headingFont);
			 	hstfOnTime.setFont(basicFont);
			 	hstfOTplayer1.setFont(basicFont);
			 	hstfOTplayer2.setFont(basicFont);
			 	hstfOTplayer3.setFont(basicFont);
			 	hstfOTplayer1points.setFont(basicFont);
				hstfOTplayer2points.setFont(basicFont);
				hstfOTplayer3points.setFont(basicFont);
				hstfOnNumber.setFont(basicFont);
				hstfONplayer1.setFont(basicFont);
				hstfONplayer2.setFont(basicFont);
				hstfONplayer3.setFont(basicFont);
				hstfONplayer1points.setFont(basicFont);
				hstfONplayer2points.setFont(basicFont);
				hstfONplayer3points.setFont(basicFont);
			
				otfOptions.setFont(headingFont);
				otfMusic.setFont(basicFont);
				otfMusicField.setFont(basicFont);
				
				htfHelp.setFont(headingFont);
			}
			
		}
		
		{//alle Positionen im Fenster
			{//alle b Positionen
				mmbSinglePlayer.setBounds(220,105,200,40);
			  	mmbMultiPlayer.setBounds(220,150,200,40);
			  	mmbOption.setBounds(220,195,200,40);
			  	mmbHighscore.setBounds(220,240,200,40);
			  	mmbHelp.setBounds(220,285,200,40);
			  	mmbExit.setBounds(220,330,200,40);
			  	
			  	spbStart.setBounds(10,10,10,10);
			  	spbBack.setBounds(10,10,10,10);
			  	
			  	hsbback.setBounds(10,10,10,10);
			  	
			    obMinus.setBounds(10,10,10,10);
			  	obPlus.setBounds(10,10,10,10);
			  	
			  	obBack.setBounds(10,10,10,10);
			}
			
		  	{//alle tf Positionen
		  		sptfSingleplayer.setBounds(220,0,200,50);
			 	sptfMap.setBounds(0,0,0,0);
			 	sptfdifficulty.setBounds(0,0,0,0);
			 	sptfName.setBounds(0,0,0,0);
			 	sptfNameField.setBounds(0,0,0,0);
			 	sptfModus.setBounds(0,0,0,0);
			 	
			 	mptfMultiplayer.setBounds(0,0,0,0);
			 	mptfMap.setBounds(0,0,0,0);
			 	
			 	hstfHighscore.setBounds(0,0,0,0);
			 	hstfOnTime.setBounds(0,0,0,0);
			 	hstfOTplayer1.setBounds(0,0,0,0);
			 	hstfOTplayer2.setBounds(0,0,0,0);
			 	hstfOTplayer3.setBounds(0,0,0,0);
			 	hstfOTplayer1points.setBounds(0,0,0,0);
				hstfOTplayer2points.setBounds(0,0,0,0);
				hstfOTplayer3points.setBounds(0,0,0,0);
				hstfOnNumber.setBounds(0,0,0,0);
				hstfONplayer1.setBounds(0,0,0,0);
				hstfONplayer2.setBounds(0,0,0,0);
				hstfONplayer3.setBounds(0,0,0,0);
				hstfONplayer1points.setBounds(0,0,0,0);
				hstfONplayer2points.setBounds(0,0,0,0);
				hstfONplayer3points.setBounds(0,0,0,0);
			
				otfOptions.setBounds(0,0,0,0);
				otfMusic.setBounds(0,0,0,0);
				otfMusicField.setBounds(0,0,0,0);
				
				htfHelp.setBounds(0,0,0,0);
		  	}
		}
		
		{
			sptfSingleplayer.setEditable(false);
		}
		
		{//alle Button actionListener
			mmbSinglePlayer.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					setCurrentLabel(lSinglePlayer);
				}
			});
			mmbMultiPlayer.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					setCurrentLabel(lMultiPlayer);
				}
			});
		}
		
		{//das einfügen der elemente in die Labels
			{//mm
				lMainMenu.add(mmbExit);
				lMainMenu.add(mmbHelp);
				lMainMenu.add(mmbHighscore);
				lMainMenu.add(mmbMultiPlayer);
				lMainMenu.add(mmbOption);
				lMainMenu.add(mmbSinglePlayer);
			}
			
			{//sp
				lSinglePlayer.add(sptfSingleplayer);
			}
			
		}
		
		{//Label einstellen
			lMainMenu.setBounds(0,0,jf.getWidth(),jf.getHeight());
			lSinglePlayer.setBounds(0,0,jf.getWidth(),jf.getHeight());
		}
		
		{//Labels einfügen in das Fenster
			jf.add(lMainMenu);
			jf.add(lSinglePlayer);
		}
		//startLabel initialisieren
		setCurrentLabel(lMainMenu);
		
		 
		 jf.setVisible(true);
	}
							
	
	
	
	
}
