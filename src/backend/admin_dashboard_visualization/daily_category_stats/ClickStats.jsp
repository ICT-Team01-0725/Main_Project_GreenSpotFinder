<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리별 일별 클릭률 분석</title>
    <!-- ECharts CDN -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/echarts/5.2.2/echarts.min.js"></script>
    <style>
        /* 전체 화면 크기 설정 */
        #container {
            width: 380px;
            height: 380px;
            margin: 0 auto;
        }
        /* 차트 크기를 100%로 설정 */
        #chart {
            width: 100%;
            height: 100%;
        }
        /* body 스타일 설정 */
        body {
            margin: 20px;
            padding: 10px;
        }
    </style>
</head>
<body>

<!-- 차트 영역 -->
<div id="container">
    <div id="chart"></div>
</div>

<script>
    // ECharts 인스턴스 초기화
    const chart = echarts.init(document.getElementById('chart'));

    // 초기 데이터 설정 (서버에서 데이터 받아오기 전 초기화)
    const chartData = [
        { name: '나무', value: 0, itemStyle: { color: '#051F93' } },
        { name: '가로수길', value: 0, itemStyle: { color: '#0932F2' } },
        { name: '보호수', value: 0, itemStyle: { color: '#4262F8' } }
    ];

    // 전체 클릭수 계산
    let totalClicks = chartData.reduce((sum, item) => sum + item.value, 0);

    // 차트 옵션 설정
    const option = {
        title: {
            text: '카테고리별 일별 클릭률 분석',
            left: 'center',
            textStyle: {
                fontSize: 24  // 차트 제목 글자 크기 설정
            }
        },
        // 툴팁 양식 및 정보 설정
        tooltip: {
            trigger: 'item',
            formatter: function (params) {
                const clickCount = params.value; // 해당 카테고리 클릭수
                const clickRate = ((clickCount / totalClicks) * 100).toFixed(2); // 클릭률 계산
                return `[${params.name}] <br>클릭수: ${clickCount} <br>클릭률: ${clickRate}%`;
            }
        },
        // 범례 숨기기
        legend: {
            show: false 
        },
        series: [
            {
                name: '클릭률',
                type: 'pie',
                radius: '50%',
                data: chartData,
                label: {
                    fontSize: 16, 
                },
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 차트에 옵션 적용
    chart.setOption(option);

    // 외부 서브카테고리 클릭 데이터를 서버로부터 받아오는 함수
    function fetchExternalClickData() {
        fetch('/api/clicks/external')  // 서버에서 외부 데이터를 가져오는 엔드포인트
        .then(response => response.json())
        .then(updatedStats => {
            console.log('외부 클릭 데이터:', updatedStats);
            updateChart(updatedStats);
        })
        .catch(error => console.error('외부 데이터 가져오기 실패:', error));
    }

    // 서버에서 받은 외부 클릭 데이터를 차트에 반영
    function updateChart(data) {
        // 카테고리별 클릭 수 데이터 갱신
        chartData[0].value = data.treeClicks;
        chartData[1].value = data.streetClicks;
        chartData[2].value = data.protectedTreeClicks;

        // 전체 클릭 수 재계산
        totalClicks = chartData.reduce((sum, item) => sum + item.value, 0);

        // 차트 데이터 갱신
        chart.setOption({
            series: [{
                data: chartData
            }]
        });

        // 툴팁에 표시될 클릭률 계산
        chart.setOption({
            tooltip: {
                formatter: function (params) {
                    const clickCount = params.value;
                    const clickRate = ((clickCount / totalClicks) * 100).toFixed(2);
                    return `[${params.name}] <br>클릭수: ${clickCount} <br>클릭률: ${clickRate}%`;
                }
            }
        });
    }

    // 페이지 로드 시, 외부 웹의 서브카테고리 클릭 데이터를 불러옵니다.
    fetchExternalClickData();
</script>

</body>
</html>
