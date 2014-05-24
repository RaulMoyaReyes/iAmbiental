<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row row-offcanvas row-offcanvas-right">
    <div class="col-xs-12 col-sm-9">
        <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Men� lateral</button>
        </p>
        <div class="row padding1em">
            <h1>Ver sensor - ${sensor.descripcion}</h1>

            <form class="form-horizontal" role="form">

                <div class="form-group">
                    <label for="inputPuertoSensor" class="col-sm-2 control-label">Id f�sico</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${sensor.idFisico}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputDescripcionSensor" class="col-sm-2 control-label">Descripci�n</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${sensor.descripcion}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label for="selectDependenciaSensor" class="col-sm-2 control-label">Dependencia</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${sensor.dependencia.nombre}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputIpSensor" class="col-sm-2 control-label">Direcci�n IP</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${sensor.ip}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputPuertoSensor" class="col-sm-2 control-label">Puerto</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${sensor.puerto}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputTipoSensor" class="col-sm-2 control-label">Tipo</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${(sensor.tipo==0)?'Otro':'Temperatura'}</p>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <a href="${appUrl}/sensores" rol="button" class="btn btn-default">Volver al listado</a>
                    </div>
                </div>
            </form>
        </div><!--/row-->
    </div><!--/span-->

    <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
        <div class="list-group">
            <a href="${appUrl}/sensores/insertar" class="list-group-item"><span class="glyphicon glyphicon-plus-sign"></span> Insertar nuevo sensor</a>
            <a href="${appUrl}/sensores/editar?id=${sensor.id}" class="list-group-item"><span class="glyphicon glyphicon-edit"></span> Editar sensor</a>
            <a href="#" class="list-group-item"><span class="glyphicon glyphicon-signal"></span> Ver hist�rico</a>
            <a href="#" class="list-group-item" onclick="modalEliminarSensor('${sensor.id}', '${sensor.descripcion}')"><span class="glyphicon glyphicon-minus-sign"></span> Eliminar sensor</a>
        </div>
        <div class="list-group">
            <c:forEach var="s" items="${sensores}" varStatus="estado">
                <a href="${appUrl}/sensores/ver?id=${s.id}" class="list-group-item ${(s.id == sensor.id)?'active':''}">${s.id} - ${s.descripcion}</a>
            </c:forEach>
        </div>
    </div><!--/span-->
</div><!--/row-->