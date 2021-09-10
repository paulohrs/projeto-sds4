import axios from 'axios';
import Chart from 'react-apexcharts';
import { SaleSun } from 'types/sales';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChart= () => {

    let ChartData : ChartData = { labels: [], series: []};

    axios.get(`${BASE_URL}sales/success-by-seller`)
        .then(response => {
            const data = response.data as SaleSun[];
            const mylabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum);

            ChartData = { labels: mylabels, series: mySeries};
            console.log(ChartData);
        });

   // const mockData = {
   //     series: [477138, 499928, 444867, 220426, 473088],
   //     labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
  //  }
    
    const options = {
        legend: {
            show: true
        }
    }

    return (
       <Chart 
            options={{...options, labels: ChartData.labels}}
            series={ChartData.series} 
            type="donut"

            />
            );
}

            export default DonutChart;