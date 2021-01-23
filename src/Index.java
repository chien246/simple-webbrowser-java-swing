import com.sun.javafx.application.PlatformImpl;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import java.awt.Scrollbar;
import javax.swing.JTextPane;
import java.awt.TextArea;
import java.awt.Cursor;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JLayeredPane;
import javax.swing.JEditorPane;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import java.awt.CardLayout;
public class Index extends JFrame implements KeyListener{
	
	private static Index frame;
	private JPanel contentPane;
	
	private JScrollPane scWEB;
	private JScrollPane scHTML;
	private JScrollPane scCSS;
	private JScrollPane scSCRIPT;
	
	private JPanel webView;
	private JPanel pnHTML;
	private JPanel pnCSS;
	private JPanel pnSCRIPT;
	
	private JEditorPane edHTML;
	private JEditorPane edCSS;
	private JEditorPane edSCRIPT;
	
	private static JTextField textField;
	private JPanel panel;
	private JButton btnBack;
	private JButton btnForward;
	private JButton btnReload;
	private JButton btnSearch;
	private JPanel panel_1;
	private JTabbedPane tabbedPane;
	private ArrayList<String> history = new ArrayList<>();
	private int d = 0;
	private Stage stage;  
    private WebView browser;  
    private JFXPanel jfxPanel;    
    private WebEngine webEngine;
    
    private ImageIcon iconBack;
    private ImageIcon iconForward;
    private ImageIcon iconReload;
    private ImageIcon iconSearch;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					File anh = new File("C:\\Users\\DO_CHIEN\\Downloads\\unnamed.jpg");
					frame = new Index();
					frame.setIconImage(ImageIO.read(anh));
					frame.setTitle("OZZO BROWSER");
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
					    public void windowOpened( WindowEvent e ){
					    	textField.requestFocus();
					    }
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Index() throws IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1107, 602);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 1, 1093, 37);
		contentPane.add(panel);
		
		iconBack = new ImageIcon("./icon/left-arrow.png");
		panel.setLayout(null);
		btnBack = new JButton(iconBack);
		btnBack.setEnabled(false);
		
		btnBack.setBorderPainted(false);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(10, 5, 25, 25);
		btnBack.setIcon(resizeIcon(iconBack, btnBack.getWidth(), btnBack.getHeight()));
		panel.add(btnBack);
		
		iconForward = new ImageIcon("./icon/right-arrow.png");
		btnForward = new JButton(iconForward);
		btnForward.setEnabled(false);
		
		btnForward.setBackground(Color.WHITE);
		btnForward.setBorderPainted(false);
		btnForward.setBounds(51, 5, 25, 25);
		btnForward.setIcon(resizeIcon(iconForward, btnForward.getWidth(), btnForward.getHeight()));
		panel.add(btnForward);
		
		iconReload = new ImageIcon("./icon/reload.png");
		btnReload = new JButton("");
		btnReload.setEnabled(false);
		
		btnReload.setBorderPainted(false);
		btnReload.setBackground(Color.WHITE);
		btnReload.setBounds(89, 5, 25, 25);
		btnReload.setIcon(resizeIcon(iconReload, btnReload.getWidth(), btnReload.getHeight()));
		panel.add(btnReload);
		
		textField = new RoundJTextField(55);
		textField.setBackground(Color.WHITE);
		textField.setBorder(BorderFactory.createEmptyBorder(5,10,5,5));
		textField.setFocusable(true);
		textField.setFocusTraversalKeysEnabled(true);
		textField.setBounds(135, 4, 906, 30);
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(textField);
		textField.setColumns(10);
		
		iconSearch = new ImageIcon("./icon/search.png");
		btnSearch = new JButton("");
		btnSearch.setBorderPainted(false);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(1051, 5, 25, 25);
		btnSearch.setIcon(resizeIcon(iconSearch, btnSearch.getWidth(), btnSearch.getHeight()));
		panel.add(btnSearch);	
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 35, 1093, 530);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scWEB = new JScrollPane();
		scWEB.setBounds(10, 10, 1073, 510);
		
		scHTML = new JScrollPane();
		scHTML.setBounds(10, 10, 1073, 510);
		
		scCSS = new JScrollPane();
		scCSS.setBounds(10, 10, 1073, 510);
		
		scSCRIPT = new JScrollPane();
		scSCRIPT.setBounds(10, 10, 1073, 510);
		
		webView = new JPanel();
		webView.setBounds(10, 10, 1073, 510);
		
		jfxPanel = new JFXPanel();
		jfxPanel.setBounds(10, 10, 973, 510);
		jfxPanel.setLayout(new BoxLayout(jfxPanel, BoxLayout.X_AXIS));
		
		pnHTML = new JPanel();
		pnHTML.setLayout(new BoxLayout(pnHTML, BoxLayout.X_AXIS));
		
		edHTML = new JEditorPane();
		edHTML.setEditable(false);
		edHTML.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pnHTML.add(edHTML);
		scHTML.setViewportView(pnHTML);
		
		
		pnCSS = new JPanel();
		pnCSS.setLayout(new BoxLayout(pnCSS, BoxLayout.X_AXIS));
		
		edCSS = new JEditorPane();
		edCSS.setEditable(false);
		edCSS.setAlignmentX(Component.RIGHT_ALIGNMENT);
		edCSS.setContentType("text/css");
		pnCSS.add(edCSS);
		scCSS.setViewportView(pnCSS);
		
		pnSCRIPT = new JPanel();
		pnSCRIPT.setLayout(new BoxLayout(pnSCRIPT, BoxLayout.X_AXIS));
		
		edSCRIPT = new JEditorPane();
		edSCRIPT.setEditable(false);
		edSCRIPT.setAlignmentX(Component.RIGHT_ALIGNMENT);
		edSCRIPT.setContentType("text/css");
		pnSCRIPT.add(edSCRIPT);
		scSCRIPT.setViewportView(pnSCRIPT);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 1073, 510);
		tabbedPane.add("WEB", jfxPanel);
		tabbedPane.add("HTML", scHTML);
		tabbedPane.add("CSS", scCSS);
		tabbedPane.add("JAVASCRIPT", scSCRIPT);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		tabbedPane.setBackgroundAt(3, Color.WHITE);
		panel_1.add(tabbedPane);
				
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				d++;
				if(d > 1) {
					btnBack.setEnabled(true);
					btnForward.setEnabled(true);
				}
				if(d > 0) {
					btnReload.setEnabled(true);
				}
				try {
					createScene(textField.getText());
					history.add(textField.getText());
					page p = getPage(textField.getText());
					edHTML.setText(p.getHtmlText());
					edCSS.setText(p.getCsstext());
					edSCRIPT.setText(p.getScriptText());
					System.out.println(p.getScriptText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnReload.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					createScene(textField.getText());
					page p = getPage(textField.getText());
					//edHTML.setText(p.getHtmlText());
					edCSS.setText(p.getCsstext());
					System.out.println(p.getScriptText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				d--;
				try {
					textField.setText(history.get(d-1));
					createScene(textField.getText());
					page p = getPage(textField.getText());
					//edHTML.setText(p.getHtmlText());
					edCSS.setText(p.getCsstext());
					System.out.println(p.getScriptText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		textField.addKeyListener(this);
		btnForward.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				d++;
				try {
					textField.setText(history.get(d-1));
					createScene(textField.getText());
					page p = getPage(textField.getText());
					//edHTML.setText(p.getHtmlText());
					edCSS.setText(p.getCsstext());
					System.out.println(p.getScriptText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		
	}
	public void keyPressed(KeyEvent e) {
		//System.out.println(e.getKeyCode());
		if(e.getKeyCode() == 10) {
			d++;
			if(d > 1) {
				btnBack.setEnabled(true);
				btnForward.setEnabled(true);
			}
			if(d > 0) {
				btnReload.setEnabled(true);
			}
			try {
				createScene(textField.getText());
				history.add(textField.getText());
				page p = getPage(textField.getText());
				edHTML.setText(p.getHtmlText());
				edCSS.setText(p.getCsstext());
				edSCRIPT.setText(p.getScriptText());
				System.out.println(p.getScriptText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
    }
 
    public void keyReleased(KeyEvent e) {
        
    }
 
    public void keyTyped(KeyEvent e) {
        
    }
	public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
	private void createScene(String url) {  
        PlatformImpl.startup(new Runnable() {  
            @Override
            public void run() {                
                browser = new WebView();
                webEngine = browser.getEngine();
                webEngine.load(url);
                
                VBox root = new VBox();  
                Scene scene = new Scene(root, 0, 0);  
                               
                ObservableList<Node> children = root.getChildren();
                children.add(browser);                     
                 
                jfxPanel.setScene(scene);  
            }  
        });  
    }
	public page getPage(String url) {
		String htmlText = "";
		String cssText = "";
		String scriptText = "";
		HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "text/html")
                .header("content-type", "text/html")
                .header("content-type", "charset=utf-8")
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            htmlText = response.body().toString();
            Document doc = Jsoup.parse(htmlText);
            cssText = getCSS(doc);
            //scriptText = getSCRIPT(doc);
            
        } catch(Exception e) {
        	e.printStackTrace();
        }
        page pa = new page(htmlText,cssText,scriptText);
		return (pa);
	}
	public String getCSS(Document doc) {
		String css = "";
		HttpClient client = HttpClient.newHttpClient();
		Elements csss = doc.select("link[type='text/css']");
		for(Element cs : csss) {
	          String urlCSS = cs.attr("href");
	          
	          HttpRequest request = HttpRequest.newBuilder()
	                  .GET()
	                  .header("accept", "text/css")
	                  .header("content-type", "text/css")
	                  .header("content-type", "charset=utf-8")
	                  .uri(URI.create(urlCSS))
	                  .build();
	          try {
	              HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	              css += response.body().toString();
	          } catch(Exception e) {
	          	e.printStackTrace();
	          }
	      }
		return css;
	}
	public String getSCRIPT(Document doc) {
		String script = "";
		getScr gets = new getScr(doc);
		script = gets.getScript();
		return script;
	}
}

class RoundJTextField extends JTextField {
    private Shape shape;
    public RoundJTextField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }
    public void setFont() {
    	
    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(getForeground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
         }
         return shape.contains(x, y);
    }
}
