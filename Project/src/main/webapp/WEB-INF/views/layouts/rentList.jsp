<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head><title>Cenfoteca | Rent - List</title></head>

<div class="container">
    <div class="well well-sm">
        <strong>Rent Available Items</strong>
        <div class="btn-group">
            <a href="#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list">
            </span>List</a> <a href="#" id="grid" class="btn btn-default btn-sm"><span
                class="glyphicon glyphicon-th"></span>Grid</a>
        </div>
    </div>
    <div id="products" class="row list-group">
        			
        <div class="item  col-xs-4 col-lg-4" ng-repeat="item in items">
            <div class="thumbnail">
                <img class="group list-group-image" style="width:250px;height:250px" src="{{item.image}}" alt="" />
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        {{item.name}}
                    </h4>
                    <p class="group inner list-group-item-text">
                        {{item.description}}
                    </p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                $5 <!-- add price todo -->
                            </p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" ng-click="rentMovie(item.idAlquiler)">Rent</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
</div>