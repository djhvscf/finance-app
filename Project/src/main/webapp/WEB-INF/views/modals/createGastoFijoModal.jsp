<div class="addNewUserModal">
	
	<div class="modal-header">
		<h3>Agregar gasto fijo</h3>
	</div>
	
	<div class="modal-body">
	
		<form id="createGastoFijoModal" name="createGastoFijoModal" class="form-horizontal" role="form">
			<div class='form-group'>
				<div ng-class="{error: onError && createGastoFijoModal.nombre.$invalid}">
					<label class='col-sm-3 control-label'>Nombre</label> 
					<div class="col-sm-8">
						<input type="text" id="nombre" class="form-control" name="nombre" placeholder="Requerido" required ng-model="requestObject.gastoFijo.nombre" />
						<span ng-show="onError && createGastoFijoModal.nombre.$error.required" class="help-inline">Requerido</span>
					</div>
				</div>
			</div>
			
			<div class='form-group'>
				<div ng-class="{error: onError && createGastoFijoModal.monto.$invalid}">
					<label class='col-sm-3 control-label'>Monto</label>
					<div class="col-sm-8">
						<input type="number" id="monto" class="form-control" name="monto" placeholder="Requerido" required ng-model="requestObject.gastoFijo.monto" />
						<span ng-show="onError && createGastoFijoModal.monto.$error.required" class="help-inline">Requerido</span>						
					</div>
				</div>
			</div>
			
			<div class='form-group'>
				<div ng-class="{error: onError && createGastoFijoModal.posibleFechaPago.$invalid}">
					<label class='col-sm-3 control-label'>Fecha pago</label> 
					<div class="col-sm-8">
						<input type="text" id="posibleFechaPago" class="form-control" name="posibleFechaPago" placeholder="Requerido" required ng-model="requestObject.gastoFijo.posibleFechaPago" />
						<span ng-show="onError && createGastoFijoModal.posibleFechaPago.$error.required" class="help-inline">Requerido</span>
					</div>
				</div>
			</div>
			
		</form>
	</div>
	
	<div class="modal-footer">
		<button class="btn btn-primary" ng-click="create($event)">Agregar</button>
		<button class="btn btn-warning" ng-click="cancel()">Cancelar</button>
	</div>
	
</div>