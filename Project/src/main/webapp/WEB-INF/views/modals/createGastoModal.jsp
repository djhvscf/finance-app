<div class="addNewUserModal">
	
	<div class="modal-header">
		<h3>Agregar gasto</h3>
	</div>
	
	<div class="modal-body">
	
		<form id="createGastoModal" name="createGastoModal" class="form-horizontal" role="form">
			<div class='form-group'>
				<div ng-class="{error: onError && createGastoModal.monto.$invalid}">
					<label class='col-sm-3 control-label'>Monto</label>
					<div class="col-sm-8">
						<input type="number" id="monto" class="form-control" name="monto" placeholder="Requerido" required ng-model="requestObject.gasto.monto" />
						<span ng-show="onError && createGastoModal.monto.$error.required" class="help-inline">Requerido</span>						
					</div>
				</div>
			</div>
	
			<div class='form-group'>
				<div ng-class="{error: onError && createGastoModal.lugar.$invalid}">
					<label class='col-sm-3 control-label'>Lugar</label> 
					<div class="col-sm-8">
						<input type="text" id="lugar" class="form-control" name="lugar" placeholder="Requerido" required ng-model="requestObject.gasto.lugar" />
						<span ng-show="onError && createGastoModal.lugar.$error.required" class="help-inline">Requerido</span>
					</div>
				</div>
			</div>
			
			<div class='form-group'>
				<div ng-class="{error: onError && createGastoModal.descripcion.$invalid}">
					<label class='col-sm-3 control-label'>Descripción</label> 
					<div class="col-sm-8">
						<input type="text" id="descripcion" class="form-control" name="descripcion" placeholder="Requerido" required ng-model="requestObject.gasto.descripcion" />
						<span ng-show="onError && createGastoModal.descripcion.$error.required" class="help-inline">Requerido</span>
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