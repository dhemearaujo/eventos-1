package models;

import play.data.*;
import javax.persistence.*;
import io.ebean.*;
import java.util.Date;


@Entity
public class Evento extends Model {
    
    @Id
    public long id;
    public String nome, descricao, organizador;
    public Double preco;
    public Date dataEvento;

    public static final Finder<Long, Evento> find = new Finder<>(Evento.class);
}