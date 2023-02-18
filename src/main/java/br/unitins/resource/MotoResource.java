package br.unitins.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.model.Moto;

@Path("/moto")
public class MotoResource {
    
    @GET
    @Produces
    public Moto test(){
        Moto m = new Moto();
        m.setMarca("triumph");
        m.setTipo("adventure");
        m.setAno(2022);
        m.setModelo("tiger 1200");
        m.setCor("vermelho");

        return m;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Moto> getAll(){
        // retorna todas as motos da tabela moto.
        return Moto.findAll().list();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Moto insert(Moto moto){
        moto.persist();
        return moto;
    }
}
