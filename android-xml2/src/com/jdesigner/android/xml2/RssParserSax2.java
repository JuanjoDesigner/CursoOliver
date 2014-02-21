package com.jdesigner.android.xml2;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.sax.StartElementListener;
import android.util.Xml;

public class RssParserSax2 {
	// declaración de atributos
	private URL rssUrl;
	private Noticia noticiaActual;

	// declaración del constructor
	public RssParserSax2(String rssUrl) {
		try {
			this.rssUrl = new URL(rssUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	// declaración de los metodos
	public List<Noticia> parse() {

		final List<Noticia> noticias = new ArrayList<Noticia>();

		RootElement root = new RootElement("rss");
		Element channel = root.getChild("channel");
		Element item = channel.getChild("item");

		// programamos el evento cada vez que entremos el la etiqueta "item"
		item.setStartElementListener(new StartElementListener() {

			@Override
			public void start(Attributes attributes) {
				// inicializamos el elemento noticiaActual
				noticiaActual = new Noticia();
			}
		});

		// programamos el evento cada vez que salgamos de la etiqueta "item"
		item.setEndElementListener(new EndElementListener() {

			@Override
			public void end() {
				// al finalizar añadimos el elemento noticiaActual al array de
				// noticias
				noticias.add(noticiaActual);
			}
		});

		// programamos el cierre de la etiqueta "title" y capturar las cadena de
		// texto
		item.getChild("title").setEndTextElementListener(
				new EndTextElementListener() {

					@Override
					public void end(String body) {
						noticiaActual.setTitulo(body);
					}
				});

		// programamos el cierre de la etiqueta "description" y capturar las
		// cadena de texto
		item.getChild("description").setEndTextElementListener(
				new EndTextElementListener() {

					@Override
					public void end(String body) {
						noticiaActual.setDescripcion(body);
					}
				});

		// programamos el cierre de la etiqueta "link" y capturar las cadena de
		// texto
		item.getChild("pubDate").setEndTextElementListener(
				new EndTextElementListener() {

					@Override
					public void end(String body) {
						noticiaActual.setFecha(body);
					}
				});

		// programamos el cierre de la etiqueta "link" y capturar las cadena de
		// texto
		item.getChild("link").setEndTextElementListener(
				new EndTextElementListener() {

					@Override
					public void end(String body) {
						noticiaActual.setLink(body);
					}
				});

		try {
			Xml.parse(getInputStream(), Xml.Encoding.UTF_8,
					root.getContentHandler());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return noticias;
	}

	private InputStream getInputStream() {
		try {
			return rssUrl.openConnection().getInputStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
