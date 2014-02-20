package com.jdesigner.android.xml1;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class RssParserSax {
	// declatamos los atributos
	private URL rssUrl;

	/**
	 * Verificamos que la URL sea correcta, en caso contrario se devuelve
	 * excepcion
	 * 
	 * @param rssUrl
	 *            URL para obtener el rss de noticias
	 */
	public RssParserSax(String rssUrl) {

		try {
			this.rssUrl = new URL(rssUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Noticia> parse() {
		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {
			SAXParser parser = factory.newSAXParser();
			RssHandler handler = new RssHandler();
			parser.parse(this.getInputStream(), handler);
			return handler.getNoticias();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private InputStream getInputStream() {
		try {
			return rssUrl.openConnection().getInputStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
