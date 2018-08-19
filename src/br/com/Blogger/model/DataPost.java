package br.com.Blogger.model;


import java.util.Date;

import javafx.scene.image.Image;
public class DataPost {

	private String autor;
	private String tema;
	private String conteudo;
	private String titulo;
	private static int id;
	private Date data;
	private Image imagem;

	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String selTema) {
		this.tema = selTema;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		DataPost.id = id;
		id = 0;
	}


	public Image getImagem() {
		return imagem;
	}
	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return autor + "\t\t" + tema + "\t\t" + titulo;
	}

}
