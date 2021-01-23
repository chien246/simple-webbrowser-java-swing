
public class page {
	private String htmlText;
	private String cssText;
	private String scriptText;
	public String getHtmlText() {
		return htmlText;
	}
	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
	}
	public String getHtmltext() {
		return htmlText;
	}
	public String getCsstext() {
		return cssText;
	}
	public void setCsstext(String csstext) {
		this.cssText = csstext;
	}
	public String getScriptText() {
		return scriptText;
	}
	public void setScriptText(String scriptText) {
		this.scriptText = scriptText;
	}
	public page(String h, String c, String s) {
		this.htmlText = h;
		this.cssText = c;
		this.scriptText = s;
	}
	public page() {
	}

}
