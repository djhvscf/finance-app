<div class="addNewUserModal">
	
	<div class="modal-header">
		<h3>Modificar gasto</h3>
	</div>
	
	<div class="modal-body">
	
		<form id="modifyGastoModal" name="modifyGastoModal" class="form-horizontal" role="form">
			<div class='form-group'>
				<div ng-class="{error: onError && modifyGastoModal.monto.$invalid}">
					<label class='col-sm-3 control-label'>Monto</label>
					<div class="col-sm-8">
						<input type="number" id="monto" class="form-control" name="monto" placeholder="Requerido" required ng-model="requestObject.gasto.monto" />
						<span ng-show="onError && modifyGastoModal.monto.$error.required" class="help-inline">Requerido</span>						
					</div>
				</div>
			</div>
	
			<div class='form-group'>
				<div ng-class="{error: onError && modifyGastoModal.lugar.$invalid}">
					<label class='col-sm-3 control-label'>Lugar</label> 
					<div class="col-sm-8">
						<input type="text" id="lugar" class="form-control" name="lugar" placeholder="Requerido" required ng-model="requestObject.gasto.lugar" />
						<span ng-show="onError && modifyGastoModal.lugar.$error.required" class="help-inline">Requerido</span>
					</div>
				</div>
			</div>
			
			<div class='form-group'>
				<div ng-class="{error: onError && modifyGastoModal.descripcion.$invalid}">
					<label class='col-sm-3 control-label'>Descripción</label> 
					<div class="col-sm-8">
						<input type="text" id="descripcion" class="form-control" name="v" placeholder="Requerido" required ng-model="requestObject.gasto.descripcion" />
						<span ng-show="onError && modifyGastoModal.descripcion.$error.required" class="help-inline">Requerido</span>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	<div class="modal-footer">
		<button class="btn btn-primary" ng-click="create($event)">Create</button>
		<button class="btn btn-warning" ng-click="cancel()">Cancel</button>
	</div>
	
</div>