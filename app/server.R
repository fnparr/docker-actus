server <- function(input, output) {
    output$distPlot <- renderPlot({
        dist <- rnorm(input$obs)
        hist(dist, col="purple", xlab="ACTUS Rshiny demo build00 - Random values")
    })
}
