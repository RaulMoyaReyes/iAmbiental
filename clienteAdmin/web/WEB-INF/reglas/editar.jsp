<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row row-offcanvas row-offcanvas-right">
    <div class="col-xs-12 col-sm-9">
        <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Men� lateral</button>
        </p>
        <div class="row padding1em">
            <h1>Editar regla sensor-actuador</h1>

            <form class="form-horizontal" role="form">

                <div class="form-group">
                    <label for="inputDescripcionRegla" class="col-sm-2 control-label">Descripci�n</label>
                    <div class="col-sm-10">
                        <input type="text" name="descripcion" class="form-control" id="inputDescripcionRegla" placeholder="Descripci�n de la regla sensor-actuador" value="${reglaSensorActuador.descripcion}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="selectSensorRegla" class="col-sm-2 control-label">Sensor</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="sensor" id="selectSensorRegla">
                            <c:forEach var="s" items="${sensores}" varStatus="estado">
                                <option value="${s.id}"  ${(s.id==reglaSensorActuador.sensor.id)?'selected="selected"':''}>${s.descripcion} (${s.dependencia.descripcion})</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="selectSensorRegla" class="col-sm-2 control-label">Dato sensor</label>
                    <div class="col-sm-10">
                        <input type="text" name="valorMin" class="form-control" id="inputValorMin" placeholder="Valor m�nimo" value="${reglaSensorActuador.valorMin}"/>
                        <input type="text" name="valorMax" class="form-control" id="inputValorMax" placeholder="Valor m�ximo" value="${reglaSensorActuador.valorMax}"/>
                        <input type="text" name="margenRuido" class="form-control" id="inputMargenRuido" placeholder="Margen de ruido" value="${reglaSensorActuador.margenRuido}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="selectActuadorRegla" class="col-sm-2 control-label">Actuador</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="actuador" id="selectActuadorRegla">
                            <c:forEach var="a" items="${actuadores}" varStatus="estado">
                                <option value="${a.id}" ${(a.id==reglaSensorActuador.actuador.id)?'selected="selected"':''}>${a.descripcion} (${a.dependencia.descripcion})</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="selectSensorRegla" class="col-sm-2 control-label">Estado actuador</label>
                    <div class="col-sm-10">
                        <input type="text" name="estadoActuador" class="form-control" id="inputEstadoActuador" placeholder="Estado a establecer el actuador" value="${reglaSensorActuador.estadoActuador}"/>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit"  name="modificar" class="btn btn-success" value="${reglaSensorActuador.id}">Guardar</button>
                        <a href="${appUrl}/reglas" rol="button" class="btn btn-danger">Cancelar</a>
                    </div>
                </div>
            </form>
        </div><!--/row-->
    </div><!--/span-->

    <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
        <div class="list-group">
            <a href="${appUrl}/reglas/insertar" class="list-group-item"><span class="glyphicon glyphicon-plus-sign"></span> Insertar nueva regla</a>
            <a href="#" class="list-group-item active"><span class="glyphicon glyphicon-edit"></span> Editar regla</a>
            <a href="#" class="list-group-item" onclick="modalEliminarReglaSensorActuador('${reglaSensorActuador.id}', '${reglaSensorActuador.descripcion}')"><span class="glyphicon glyphicon-minus-sign"></span> Eliminar regla</a>
        </div>
        <div class="list-group">
            <c:forEach var="r" items="${reglasSensorActuador}" varStatus="estado">
                <a href="${appUrl}/reglas/ver?id=${r.id}" class="list-group-item ${(r.id==reglaSensorActuador.id)?'active':''}">${r.id} - ${r.descripcion}</a>
            </c:forEach>
        </div>
    </div><!--/span-->
</div><!--/row-->