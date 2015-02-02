<div class="addNewUserModal">
	
	<div class="modal-header">
		<h3>Modifcar gasto fijo</h3>
	</div>
	
	<div class="modal-body">
	
		<form id="modifyGastoFijoModal" name="modifyGastoFijoModal" class="form-horizontal" role="form">
			<div class='form-group'>
				<div ng-class="{error: onError && modifyGastoFijoModal.nombre.$invalid}">
					<label class='col-sm-3 control-label'>Nombre</label> 
					<div class="col-sm-8">
						<input type="text" id="nombre" class="form-control" name="nombre" placeholder="Requerido" required ng-model="requestObject.gastoFijo.nombre" />
						<span ng-show="onError && modifyGastoFijoModal.nombre.$error.required" class="help-inline">Requerido</span>
					</div>
				</div>
			</div>
			
			<div class='form-group'>
				<div ng-class="{error: onError && modifyGastoFijoModal.monto.$invalid}">
					<label class='col-sm-3 control-label'>Monto</label>
					<div class="col-sm-8">
						<input type="text" id="monto" class="form-control" name="monto" placeholder="Requerido" required ng-model="requestObject.gastoFijo.monto" />
						<span ng-show="onError && modifyGastoFijoModal.monto.$error.required" class="help-inline">Requerido</span>						
					</div>
				</div>
			</div>
			
			<div class='form-group'>
				<div ng-class="{error: onError && modifyGastoFijoModal.posibleFechaPago.$invalid}">
					<label class='col-sm-3 control-label'>Fecha pago</label> 
					<div class="col-sm-8">
						<input type="text" id="posibleFechaPago" class="form-control" name="posibleFechaPago" placeholder="Requerido" required ng-model="requestObject.gastoFijo.posibleFechaPago" />
						<span ng-show="onError && modifyGastoFijoModal.posibleFechaPago.$error.required" class="help-inline">Requerido</span>
					</div>
				</div>
			</div>
			
		</form>
	</div>
	
	<div class="modal-footer">
		<button class="btn btn-primary" ng-click="create($event)">Modificar</button>
		<button class="btn btn-warning" ng-click="cancel()">Cancelar</button>
	</div>
	
</div>