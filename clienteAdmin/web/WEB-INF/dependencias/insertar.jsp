<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row row-offcanvas row-offcanvas-right">
    <div class="col-xs-12 col-sm-9">
        <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Men� lateral</button>
        </p>
        <div class="row padding1em">
            <h1>Insertar nueva dependencia</h1>

            <form class="form-horizontal" role="form">

                <div class="form-group">
                    <label for="inputNombreDependencia" class="col-sm-2 control-label">Ubicaci�n</label>
                    <div class="col-sm-10">
                        <input type="text" name="nombre" class="form-control" id="inputNombreDependencia" placeholder="Nombre de la dependencia"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="textareaDescripcionDependencia" class="col-sm-2 control-label">Descripci�n</label>
                    <div class="col-sm-10">
                        <input type="text" name="descripcion" class="form-control" id="textareaDescripcionDependencia" placeholder="Descripci�n de la dependencia"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" name ="crear" class="btn btn-success">Guardar</button>
                        <a href="${appUrl}/dependencias" rol="button" class="btn btn-danger">Cancelar</a>
                    </div>
                </div>
            </form>
        </div><!--/row-->
    </div><!--/span-->

    <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
        <div class="list-group">
            <a href="#" class="list-group-item active"><span class="glyphicon glyphicon-plus-sign"></span> Insertar nueva dependencia</a>
        </div>
        <div class="list-group">
            <c:forEach var="d" items="${dependencias}" varStatus="estado">
                <a href="${appUrl}/dependencias/ver?id=${d.id}" class="list-group-item">${d.id} - ${d.nombre}</a>
            </c:forEach>
        </div>
    </div><!--/span-->
</div><!--/row-->