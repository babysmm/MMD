window.onload=function(){
     
    var data1 = echarts.init(document.getElementById('data1'));
    //var oneRight = echarts.init(document.getElementById('oneRight'));
    //var twoleft = echarts.init(document.getElementById('twoleft'));
    //var tworight = echarts.init(document.getElementById('tworight'));


    option = {
    title: {
        text: ''
    },
    tooltip : {
        trigger: 'axis',
        axisPointer: {
            type: 'cross',
            label: {
                backgroundColor: '#6a7985'
            }
        }
    },
    legend: {
        data:['喵喵奶茶1','喵喵奶茶2','喵喵奶茶3','喵喵奶茶4','喵喵奶茶5']
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    grid: {
        width:'98%',
        height:'80%',
        left:'0%',
        right:'10%',
        bottom: '3%',
        containLabel: true
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            data : ['周一','周二','周三','周四','周五','周六','周日']
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'喵喵奶茶1',
            type:'line',
            stack: '总量',
            areaStyle: {},
            data:[120, 132, 101, 134, 90, 230, 210]
        },
        {
            name:'喵喵奶茶2',
            type:'line',
            stack: '总量',
            areaStyle: {},
            data:[220, 182, 191, 234, 290, 330, 310]
        },
        {
            name:'喵喵奶茶3',
            type:'line',
            stack: '总量',
            areaStyle: {},
            data:[150, 232, 201, 154, 190, 330, 410]
        },
        {
            name:'喵喵奶茶4',
            type:'line',
            stack: '总量',
            areaStyle: {normal: {}},
            data:[320, 332, 301, 334, 390, 330, 320]
        },
        {
            name:'喵喵奶茶5',
            type:'line',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'top'
                }
            },
            areaStyle: {normal: {}},
            data:[820, 932, 901, 934, 1290, 1330, 1320]
        }
    ]
};

    data1.setOption(option);
   // oneRight.setOption(option);
    //twoleft.setOption(option);
    //tworight.setOption(option);



}