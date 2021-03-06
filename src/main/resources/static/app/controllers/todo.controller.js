angular.module("myApp")
    .controller('todoCtrl', function ($scope, Todolist) {
        $scope.todoList = [];

        Todolist.get().then(function mySuccess(response) {
            $scope.todoList = response.data;
        }, function myError(response) {
            $scope.todoList = response.statusText;
        });


        $scope.todoAdd = function () {
            debugger;

            Todolist.create({title: $scope.todoInput})
                .then(function (response) {
                    $scope.todoList.push({id: response.data.id, title: response.data.title, marked: false});
                });

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
