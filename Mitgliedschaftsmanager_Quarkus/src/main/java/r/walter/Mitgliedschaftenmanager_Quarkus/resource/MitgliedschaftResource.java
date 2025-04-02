package r.walter.Mitgliedschaftenmanager_Quarkus.resource;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import r.walter.Mitgliedschaftenmanager_Quarkus.modul.Mitgliedschaft;
import r.walter.Mitgliedschaftenmanager_Quarkus.service.MitgliedschaftService;

import java.net.URI;

@Path("/mitgliedschaften")
public class MitgliedschaftResource {

   @Inject
   MitgliedschaftService service;

    @Inject
    Template index;
    @Inject
    Template edit;
    @Inject
    Template create;

    @GET
    public TemplateInstance home() {
        return index.data("mitgliedschaften", service.findAll(), "page", "homepage");
    }

    @GET
    @Path("/add")
    public TemplateInstance addForm() {
        return create.data("mitgliedschaft", service.setMitgliedschaft(), "page", "add");
    }

    @GET
    @Path("/update/{id}")
    public TemplateInstance editForm(@PathParam("id") int id) {
        return edit.data("mitgliedschaft", service.findById(id), "page", "edit");
    }

    @POST
    @Path("/sql/save")
    public Response save(Mitgliedschaft mitglied) {
        service.save(mitglied);
        return Response.seeOther(URI.create("/mitgliedschaften")).build();
    }

    @POST
    @Path("/sql/update")
    public Response update(Mitgliedschaft mitglied) {
        service.update(mitglied);
        return Response.seeOther(URI.create("/mitgliedschaften")).build();
    }

    @GET
    @Path("/sql/remove/{id}")
    public Response delete(@PathParam("id") int id) {
        service.delete(id);
        return Response.seeOther(URI.create("/mitgliedschaften")).build();
    }

    @GET
    @Path("/search")
    public TemplateInstance search(@QueryParam("keyword") String keyword) {
        return index.data("mitgliedschaften", service.search(keyword), "page", "homepage");
    }
}
