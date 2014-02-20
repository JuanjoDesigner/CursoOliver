package com.jdesigner.android.xml1;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RssHandler extends DefaultHandler {
	// declaración de atributos
	private List<Noticia> noticias; // guarda la lista de noticias recibida
	private Noticia noticiaActual; // compone los elementos de una noticia para
									// añadir a la lista
	private StringBuilder sbTexto; // guarda la cadena de texto de la etiquetas
									// de la noticia

	// declaración de metodos
	@Override
	public void startDocument() throws SAXException {
		// inicializamos las variables
		super.startDocument();

		noticias = new ArrayList<Noticia>();
		sbTexto = new StringBuilder();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// inicializamos noticiaActual cuando llega el evento de la etiqueta
		// <item>
		super.startElement(uri, localName, qName, attributes);

		if (localName.equals("item")) {
			noticiaActual = new Noticia();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// rellenamos la estructura noticiaActual
		super.characters(ch, start, length);

		// noticiaActual tiene valor cuando estamos dentro de una etiqueta
		// <item>
		if (this.noticiaActual != null) {
			sbTexto.append(ch, start, length);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// compone los elementos de sbTexto para añadir a la lista de noticias
		super.endElement(uri, localName, qName);

		if (this.noticiaActual != null) {
			if (localName.equals("title")) {
				noticiaActual.setTitulo(sbTexto.toString());
			} else if (localName.equals("link")) {
				noticiaActual.setLink(sbTexto.toString());
			} else if (localName.equals("description")) {
				noticiaActual.setDescripcion(sbTexto.toString());
			} else if (localName.equals("guid")) {
				noticiaActual.setGuid(sbTexto.toString());
			} else if (localName.equals("pubDate")) {
				noticiaActual.setFecha(sbTexto.toString());
			} else if (localName.equals("item")) {
				noticias.add(noticiaActual);
			}

			sbTexto.setLength(0);
		}
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}
}
