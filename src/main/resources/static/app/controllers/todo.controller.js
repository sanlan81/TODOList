angular.module("myApp")
.controller('todoCtrl', function($scope, Todolist) {
    $scope.todoList = [];

    Todolist.get().then(function mySuccess(response) {
        $scope.todoList = response.data;
    }, function myError(response) {
        $scope.todoList = response.statusText;
    });

 /*   $http({
        method : "GET",
        url : '/api/v1/users/todolist'
    }).then(function mySuccess(response) {
        $scope.todoList = response.data;
    }, function myError(response) {
        $scope.todoList = response.statusText;
    });*/

    $scope.todoAdd = function() {
        $scope.todoList.push({title:$scope.todoInput, done:false});
        Todolist.create({titleTodoList:$scope.todoInput});
        $scope.todoInput = "";
    };

    $scope.remove = function() {
        var oldList = $scope.todoList;
        $scope.todoList = [];
        angular.forEach(oldList, function(x) {
            if (!x.done)
            {$scope.todoList.push(x)}
            else {Todolist.delete(x.id)};
        });
    };
});
