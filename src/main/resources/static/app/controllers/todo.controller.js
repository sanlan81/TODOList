angular.module("myApp")
    .controller('todoCtrl', function ($scope, Todolist) {
        $scope.todoList = [];

        Todolist.get().then(function mySuccess(response) {
            $scope.todoList = response.data;
        }, function myError(response) {
            $scope.todoList = response.statusText;
        });

        $scope.todoAdd = function () {

            Todolist.create({titleTodoList: $scope.todoInput})
                .then(function (response) {
                    console.log($scope.todoList);
                    console.log(response);
                    $scope.todoList.push({id:response.id, title: response.titleTodoList, marked: false});
                    console.log($scope.todoList);
                });

           /* $scope.todoList.push({title: $scope.todoInput, marked: false});
            Todolist.create({titleTodoList: $scope.todoInput});*/
            $scope.todoInput = "";
        };

        $scope.remove = function () {
            var oldList = $scope.todoList;
            $scope.todoList = [];
            angular.forEach(oldList, function (x) {
                if (!x.marked) {
                    $scope.todoList.push(x)
                }
                else {
                    Todolist.delete(x.id)
                }
                ;
            });
        };
    });
