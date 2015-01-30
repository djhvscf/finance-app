<div class="addNewUserModal">
	
	<div class="modal-header">
		<h3>Agregar salario</h3>
	</div>
	
	<div class="modal-body">
	
		<form id="createSalarioModal" name="createSalarioModal" class="form-horizontal" role="form">
			<div class='form-group'>
				<div ng-class="{error: onError && createSalarioModal.monto.$invalid}">
					<label class='col-sm-3 control-label'>Monto</label>
					<div class="col-sm-8">
						<input type="number" id="monto" class="form-control" name="monto" placeholder="Requerido" required ng-model="requestObject.salario.monto" />
						<span ng-show="onError && createSalarioModal.monto.$error.required" class="help-inline">Requerido</span>						
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