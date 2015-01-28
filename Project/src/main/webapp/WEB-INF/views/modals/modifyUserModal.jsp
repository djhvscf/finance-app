<div class="editUserModal">
	
	<div class="modal-header">
		<h3>Modify User</h3>
	</div>
	
	<div class="modal-body">
	
		<form id="modifyUserForm" name="modifyUserForm" class="form-horizontal" role="form">
			<div class='form-group'>
				<div ng-class="{error: onError && modifyUserForm.email.$invalid}">
					<label class='col-sm-3 control-label'>Tipo Usuario</label> 
					<div class="col-sm-8">
						<select name="tipousuario" id="tipousuario" class="form-control" style="width: 220px;"
							ng-model="requestObject.user.idTipoUsuario" tabindex="5"
							ng-options="tp.idTipoUsuario as tp.tipo for tp in tipoUsuarioList"
							required> 
						</select>
						<span ng-show="onError && modifyUserForm.tipousuario.$error.required" class="help-inline">Required</span>
					</div>
				</div>
			</div>
	
			<div class='form-group'>
				<div ng-class="{error: onError && modifyUserForm.firstName.$invalid}">
					<label class='col-sm-3 control-label'>First Name</label>
					<div class="col-sm-8">
						<input type="text" id="firstname" class="form-control" name="firstname" placeholder="Required" required ng-model="requestObject.user.firstname" />
						<span ng-show="onError && modifyUserForm.firstname.$error.required" class="help-inline">Required</span>						
					</div>
				</div>
			</div>
	
			<div class='form-group'>
				<div ng-class="{error: onError && modifyUserForm.lastName.$invalid}">
					<label class='col-sm-3 control-label'>Last Name</label> 
					<div class="col-sm-8">
						<input type="text" id="lastname" class="form-control" name="lastname" placeholder="Required" required ng-model="requestObject.user.lastname" />
						<span ng-show="onError && modifyUserForm.lastname.$error.required" class="help-inline">Required</span>
					</div>
				</div>
			</div>
	
			<div class='form-group'>
				<div ng-class="{error: onError && modifyUserForm.email.$invalid}">
					<label class='col-sm-3 control-label'>Email</label> 
					<div class="col-sm-8">
						<input type="text" id="email" class="form-control" 
							name="email" placeholder="Required" 
							required ng-model="requestObject.user.email"
							ng-pattern="EMAIL_REGEXP"
						/>
						<span ng-show="onError && modifyUserForm.email.$error.required" class="help-inline">Required</span>
						<span ng-show="onError && modifyUserForm.email.$error.pattern" class="help-inline">Correo invalido</span>
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