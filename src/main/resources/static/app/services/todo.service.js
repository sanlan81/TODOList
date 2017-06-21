angular.module('myApp')
    .factory('Todolist', ['$http', function ($http) {
        return {
            get: function () {
                return $http.get('/api/v1/users/todolist');
            },
            create: function (todoData) {
                return $http.post('/api/v1/users/todolist', todoData);
            },

            delete: function (id) {
                return $http.delete('/api/v1/users/todolist/' + id);
            }
        }
    }]);