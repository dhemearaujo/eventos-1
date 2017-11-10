package controllers;

import play.mvc.*;
import play.data.*;

import javax.inject.Inject;

import views.html.*;

import models.*;
import java.util.List;

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
        DynamicForm formulario = formFactory.form().bindFromRequest();
        evento.nome = formulario.get("nome");
        evento.descricao = formulario.get("desc");
        evento.organizador = formulario.get("un");
        evento.preco = Double.valueOf(formulario.get("preco"));

        evento.save();

        flash("success", evento.nome+ " Salvo com sucesso");

        return redirect(routes.HomeController.cadastroDeEvento());
    }

       
}

