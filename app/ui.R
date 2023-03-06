ui <- fluidPage(
    mainPanel(
        sliderInput("obs",
            "ACTUS Rshiny demo build00 - Number of observations",
            min = 1,
            max = 5000,
            value = 100),
        plotOutput("distPlot")
    )
)
