'use strict';
angular.module('jfall.Model').

factory('Task', function () {

    function TaskAction(type, behandelaars) {
        this.type = type;
        this.behandelaars = behandelaars;
    }

    function parseUrgentie(urgentie) {
        var result = {};
        switch (urgentie) {
            case 'Hoog': result.value = 2; break;
            case 'Middel': result.value = 1; break;
            case 'Laag': result.value = 0; break;
        }
        result.name = urgentie;
        return result;
    }

    function Task(id, status, titel, datum, proces, urgentie, taakActie, behandelaar) {
        this.id = id;
        this.status = status;
        var parts = titel.split(" Dln: ");
        this.titel = parts[0];
        this.deelnemer = parts[1];
        this.startDatum = datum;
        this.proces = proces;
        this.taakactie = taakActie;
        this.behandelaar = behandelaar;
        this.urgentie = parseUrgentie(urgentie);
    };

    Task.getValues = function() {
        return [
            {id: '2', name: 'Hoog'},
            {id: '1', name: 'Middel'},
            {id: '0', name: 'Laag'}
        ];
    };

    Task.fromJson = function (json) {
        var taakActie = json.taakactie ? new TaskAction(json.taakactie.type, json.taakactie.behandelaars) : undefined;
        var taak = new Task(json.id, json.status, json.titel, json.startDatum, json.proces, json.urgentie, taakActie, json.behandelaar);
        return taak;
    };

    Task.fromJsonArray = function (jsonArray) {
        var tasks = new Array();
        angular.forEach(jsonArray, function(element) {
            tasks.push(Task.fromJson(element));
        });
        return tasks;
    };

    return Task;
});