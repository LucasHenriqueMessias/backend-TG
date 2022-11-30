    //1º Grafico
    google.charts.load('current', {'packages': ['corechart'], 'language': 'pt-br'});
    google.charts.setOnLoadCallback(drawChartDiario);
    function drawChartDiario() {
    
    var data = google.visualization.arrayToDataTable([
        ['Movimentação', 'Produto'],
        ['Entradas', 60],
        ['Saídas', 20],
        ['Perdas', 5]
    ]);
    
    var options = {
        title: 'Diário',
        colors:['#2797CF','#39BBDB', '#2BE3DA']
       
    };
    
    var chart = new google.visualization.PieChart(document.getElementById('diario'));

    chart.draw(data, options);
    };
    
    
    //2° Grafico
    google.charts.load('current', {'packages': ['corechart'], 'language': 'pt-br'});
    google.charts.setOnLoadCallback(drawChartSemanal);
    function drawChartSemanal() {
    
    var data = google.visualization.arrayToDataTable([
        ['Movimentação', 'Produto'],
        ['Entradas', 500],
        ['Saídas', 300],
        ['Perdas', 100]
    ]);
    
    var options = {
        title: 'Semanal',
        colors:['#2797CF','#39BBDB', '#2BE3DA']
    };
    
    var chart = new google.visualization.PieChart(document.getElementById('semanal'));
    
    chart.draw(data, options);
    };

    //3° Grafico
    google.charts.load('current', {'packages': ['corechart'], 'language': 'pt-br'});
    google.charts.setOnLoadCallback(drawChartAnual);
    function drawChartAnual() {
    
    var data = google.visualization.arrayToDataTable([
        ['Movimentação', 'Produto'],
        ['Entradas', 3000],
        ['Saídas', 500],
        ['Perdas', 200]
    ]);
    
    var options = {
        title: 'Anual',
        colors:['#2797CF','#39BBDB', '#2BE3DA']
    };
    
    var chart = new google.visualization.PieChart(document.getElementById('anual'));

    chart.draw(data, options);
    };

    //Gráfico coluna
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Mês", "Unidade", { role: "style" } ],
        ["Janeiro", 40, "#2797CF"],
        ["Março", 88, "#2BE3DA"],
        ["Junho", 60, "#39BBDB"],
     
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        width: 600,
        height: 400,
        bar: {groupWidth: "20%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
  }
