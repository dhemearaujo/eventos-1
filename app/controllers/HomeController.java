package controllers;

import play.mvc.*;
import play.data.*;


import javax.inject.Inject;

import views.html.*;

import models.*;
import java.util.List;
import java.util.Date;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    FormFactory formFactory;

    @Inject
    Evento evento;

    
    public Result index() {
        return ok(index.render("Projeto Eventos POOW"));
    }

    public Result cadastroDeEvento(){
        Form<Evento> formEvento = formFactory.form(Evento.class).bindFromRequest();
    	return ok(cadastroDeEvento.render("Cadastro", formEvento));

    }

    public Result listaTudo(){
        List<Evento> listDeEventos = evento.find.all();
        
        return ok(listagem.render(listDeEventos));

    }

    public Result cadastroDeNovoEvento(){
        Form<Evento> formEvento = formFactory.form(Evento.class).bindFromRequest();
        Evento e = formEvento.get();
        e.save();

        flash("success", e.nome+ " Salvo com sucesso");

        return redirect(routes.HomeController.index());
    }

       
}

