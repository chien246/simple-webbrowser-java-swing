import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class getScr {
	Document doc;
	String script;
	public getScr(Document doc) {
		this.doc = doc;
	}
	public String getScript() {
		getScript(doc);
		return script;
	}
	public void getScript(Document doc) {
		HttpClient client = HttpClient.newHttpClient();
		Elements scr = doc.select("script");
		for(Element sc : scr) {
			String urlSCRIPT = sc.attr("src");
	          script += urlSCRIPT;
	          HttpRequest request = HttpRequest.newBuilder()
	                  .GET()
	                  .header("accept", "text/html")
	                  .header("content-type", "text/html")
	                  .header("content-type", "charset=utf-8")
	                  .uri(URI.create(urlSCRIPT))
	                  .build();
	          try {
	              HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	              script += response.body().toString();
	          } catch(Exception e) {
	          	e.printStackTrace();
	          }
		}
	}

}
