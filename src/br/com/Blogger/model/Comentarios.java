package br.com.Blogger.model;

import java.util.Date;

public class Comentarios {

	private Date dataComment;
	private String nomeComment;
	private String comentario;

	public Date getDataComment() {
		return dataComment;
	}
	public void setDataComment(Date dataComment) {
		this.dataComment = dataComment;
	}
	public String getNomeComment() {
		return nomeComment;
	}
	public void setNomeComment(String nomeComment) {
		this.nomeComment = nomeComment;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return nomeComment + "\t\t" + comentario;
	}
}
