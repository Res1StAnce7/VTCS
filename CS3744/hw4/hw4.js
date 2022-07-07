function YahooFinance(){
    let margin ={top: 20, right: 5, bottom: 30, left: 75}
    d3.json("finance.json").then(data=>{
        let svg = d3.select("#fetch").append('svg')

        let pxX = 600 - margin.left - margin.right,
            pxY = 300 - margin.top - margin.bottom
            svg = svg.attr('width', 600 + margin.left + margin.right).attr('height',+
            300 + margin.top + margin.bottom)
            .style('background', 'lightgrey')
            .append('g')
            .attr('transform', `translate(${margin.left} ${margin.top + 30})`)

        let {result} = data.chart
        let {timestamp, comparisons} = result[0]
        let date = []
        timestamp.forEach(data=> {
            date.push(new Date(data*1000))
        })

        date.unshift(new Date(date[0].getTime() - (24*60*700*1000)))
        date.push(new Date(date[date.length - 1].getTime() + (24*60*100*1000)))

        let scX = d3.scaleTime().domain([date[0], date[date.length - 1]]).range([0, pxX])

        let [minVal, maxVal] = [Infinity, -Infinity]
        comparisons.forEach(tick=>{
            tick.high.forEach(val=>{
                    maxVal = Math.max(maxVal, val)
                    minVal = Math.min(minVal, val)
                }
            )
        })

        let scY = d3.scaleLinear().domain([0, maxVal + (3000 - maxVal)]).range([pxY, 0])
        let color = ['red', 'blue', 'yellow', 'green']

        comparisons.forEach((tick, idx)=>{
            let {high,symbol} = tick
            let g = svg.append("g")
            g.selectAll('circle')
                .data(high)
                .enter()
            for (let i = 1; i < high.length; i++) {
                g.append('circle')
                    .attr('cx', scX(date[i]))
                    .attr('cy', scY(high[i]))
                    .attr('r', 3)
                    .attr('fill', color[idx])
                    .attr('opacity', 1)
            }

            for (let i = 2; i < high.length; i++) {
                g.append('line')
                    .attr('x1', scX(date[i]))
                    .attr('y1', scY(high[i]))
                    .attr('x2', scX(date[i - 1]))
                    .attr('y2', scY(high[i - 1]))
                    .attr('stroke', color[idx])
                    .attr('stroke-width', 1.5)
                    .attr('opacity', 1)
            }

            let toolTip = svg.append('text')
            g.selectAll('circle')
                .on('mouseover', function(e){
                    let [x, y] = d3.pointer(e, this)
                    let yVal = parseFloat(scY.invert(y)).toFixed(2);
                    toolTip.attr('x', x)
                        .attr('y', y)
                        .text(yVal)
                        .attr('fill', 'black')
                        .attr('font-size', '12px')
                        .attr('opacity', 1)
                    })
                .on('mouseleave', function(){
                        setTimeout(()=>{
                            toolTip.attr('opacity', 0)
                        }, 3000)
                    })
            g.append('text')
                .attr('x', pxX + 20)
                .attr('y', d=>200 - idx * 20)
                .attr("fill", color[idx])
                .text(symbol)
        })

        let axis = d3.axisRight(scY)
        svg.append('g').call(axis)
        axis = d3.axisTop(scX)
        svg.append('g')
            .attr('transform', `translate(0, ${pxY + 10})`)
            .call(axis)
            .selectAll('text')
            .attr('transform', 'rotate(90)translate(20, 0)')

        const xAxisGrid = d3.axisBottom(scX).tickSize(-pxX+270).tickFormat('').ticks(10);
        svg.append('g')
            .attr('class','x, axis-grid')
            .attr('transform', `translate(0, ${pxY})`).call(xAxisGrid)

        const yAxisGrid = d3.axisLeft(scY).tickSize(-pxY-270).tickFormat('').ticks(10);
        svg.append('g')
            .attr('class','y, axis-grid')
            .call(yAxisGrid)
    }).catch(err=>console.log(err))
}

function drawPieChart(){
    let collectedData = {
        webTech: [
            {skill: "None", count: 7},
            {skill: "Beginner", count: 10},
            {skill: "Intermediate", count: 4},
            {skill: "Advanced", count: 1}
        ]
    }

    let g = d3.select('#d3').append('svg')
        .attr('width', 500)
        .attr('height', 300)
        .style('background', 'lightgrey')
        .append('g')
        .attr('class', 'pie-container')
        .attr('transform', 'translate(250, 150)')

    let color = ['orange', 'green', 'red', 'purple']
    let arc = d3.arc()
        .innerRadius(15)
        .outerRadius(120)
    let pie = d3.pie()
        .value(d=>d.count)
        .sort(null)

    let pieData = pie(collectedData.webTech)
        g.selectAll('path')
        .data(pieData)
        .enter()
        .append('path')
        .attr('d', arc)
        .attr('fill', (d, i)=>color[i])
        .attr('opacity', 2)
        .attr('stroke', 'black')
        .attr('stroke-width', 1)
        .attr('stroke-opacity', 1)
        .attr('class', 'pie-path')

        g.selectAll('text')
        .data(pieData)
        .enter()
        .append('text')
        .attr('transform', d=>`translate(${arc.centroid(d)})`)
        .attr('text-anchor', 'middle')
        .text(d=>d.data.skill)
        .attr('fill', 'black')
        .attr('font-size', '12px')
        .attr('opacity', 1)
        .attr('class', 'pie-text')
}