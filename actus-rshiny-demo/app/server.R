# Define server logic required to create the cash flows of a simple bond
server <- function(input, output) {
  
  #reactive creation of the example bond
  # set the ACTUS serverURL
  serverURL = "https://demo.actusfrf.org:8080/"
  #   serverURL <- "http://ractus.ch:8080/"
  
  #read the data files from inside of the package
  falling_fp <- system.file("extdata","UST5Y_fallingRates.csv", 
                            package = "FEMSdevBase")
  rising_fp <-  system.file("extdata","UST5Y_risingRates.csv", 
                            package = "FEMSdevBase")
  steady_fp <-  system.file("extdata","UST5Y_steadyRates.csv", 
                            package = "FEMSdevBase")
  recovering_fp <-  system.file("extdata","UST5Y_recoveringRates.csv", 
                                package = "FEMSdevBase")
  #create ACTUS ReferenceIndex
  rfx_falling <- sampleReferenceIndex(rxdfp = falling_fp,
                                      rfID = "UST5Y_fallingRates", 
                                      moc = "YC_EA_AAA",base = 100 )
  rfx_rising <- sampleReferenceIndex(rising_fp,"UST5Y_risingRates",
                                     "YC_EA_AAA",100 )
  rfx_steady <- sampleReferenceIndex(steady_fp,"UST5Y_steadyRates",
                                     "YC_EA_AAA",100 )
  rfx_recovering <- sampleReferenceIndex(recovering_fp,"UST5Y_steadyRates",
                                         "YC_EA_AAA",100 )
  #reactive creation of the example bond
  observe({
    cnt1 <- reactive({loan(input$contractType, as.character(input$issueDate),
                           maturity = paste(input$maturity, "years"), 
                           nominal = input$nominal, coupon = input$coupon,
                           paymentFreq = input$paymentFreq, role = "RPA",
                           rateResetFreq = input$rateResetFreq,
                           rateResetSpread = input$rateResetSpread )
    })
    
    #reactive creation of the events for the bond
    if(input$rfScenarioBond == "increasing Rates"){
      evs1 <- reactive({generateEventSeries(contract = cnt1(), 
                                            list(rfx_rising),
                                            serverURL  
      )
      })
    }
    if(input$rfScenarioBond == "decreasing Rates"){
      evs1 <- reactive({generateEventSeries(contract = cnt1(), 
                                            list(rfx_falling),
                                            serverURL  
      )
      })
    }
    if(input$rfScenarioBond == "steady Rates"){
      evs1 <- reactive({generateEventSeries(contract = cnt1(), 
                                            list(rfx_steady),
                                            serverURL  
      )
      })
    }
    if(input$rfScenarioBond == "recovering Rates"){
      evs1 <- reactive({generateEventSeries(contract = cnt1(), 
                                            list(rfx_recovering),
                                            serverURL  
      )
      })
    }
    #creation of the desired plot
    output$cashFlowPlot <- renderPlot({
      cashflowPlot(evs1())
    })
    
    #optional data table of the event list
    output$CFDF <- renderDataTable({
      evs1()$events_df
    })
  })   #observe close
  
  # reading of the different Rate scenario datafiles
  steadyRates <-      read.csv(system.file("extdata","UST5Y_steadyRates.csv", 
                                           package = "FEMSdevBase"))
  increasingRates <-  read.csv(system.file("extdata","UST5Y_risingRates.csv", 
                                           package = "FEMSdevBase"))
  decreasingRates <-  read.csv(system.file("extdata","UST5Y_fallingRates.csv", 
                                           package = "FEMSdevBase"))
  recoveringRates <-  read.csv(system.file("extdata","UST5Y_recoveringRates.csv",
                                           package = "FEMSdevBase"))
  
  # aggregate to monthly for quick nice looking plots 
  monthlySteadyRates     <- monthlyAverageRate(steadyRates)
  monthlyIncreasingRates <- monthlyAverageRate(increasingRates)
  monthlyDecreasingRates <- monthlyAverageRate(decreasingRates)
  monthlyRecoveringRates <- monthlyAverageRate(recoveringRates)
  
  #desired plot outbut based on selection of input with label: "dataSetName"
  observe({ 
    
    if(input$dataSetName == "Steady Rates"){
      plot <-  ggplot(monthlySteadyRates, aes(x=Date,y=Rate)) +
        geom_line(colour = "black") +
        labs(title = "Steady rates scenario - US Treasury 5 Year Rates")
    }
    
    if(input$dataSetName == "Increasing Rates"){
      plot<- ggplot(monthlyIncreasingRates, aes(x=Date,y=Rate)) +
        geom_line(colour = "black") +
        labs(title = "Increasing rates scenario - US Treasury 5 Year Rates")
    }
    
    if(input$dataSetName == "Decreasing Rates"){
      plot <- ggplot(monthlyDecreasingRates, aes(x=Date,y=Rate)) +
        geom_line(colour = "black") +
        labs(title = "Decreasing rates scenario - US Treasury 5 Year Rates")
    }
    
    if(input$dataSetName == "Recovering Rates"){
      plot <- ggplot(monthlyRecoveringRates, aes(x=Date,y=Rate)) +
        geom_line(colour = "black") +
        labs(title = "Recovering rates scenario - US Treasury 5 Year Rates")
    }
    
    output$ratesPlot <- renderPlot({ plot })
    
  })      # observe close
  
  observe({
    if(input$ptfFile == "BondPortfolio"){
      cdfn <- system.file("extdata","BondPortfolio.csv",package = "FEMSdevBase")
    }
    if(input$ptfFile == "MortgagePortfolio"){
      cdfn <- system.file("extdata","AnnuityPortfolio.csv",package = "FEMSdevBase")
    }
    rfdfn <- system.file("extdata","RiskFactors.csv",package = "FEMSdevBase")
    
    #create the portfolio with the respective files
    ptf   <-  samplePortfolio(cdfn,rfdfn)
    
    portfolioDF <- read.csv(cdfn)
    #portfolioDF <- portfolioDF[ , colSums(portfolioDF == "NULL") < nrow(portfolioDF)] 
    #still too many columns therefore, manual selection of most important columns
    portfolioDF <- portfolioDF[,c("contractType","statusDate","contractRole","contractID",
                                  "nominalInterestRate","currency","initialExchangeDate",
                                  "premiumDiscountAtIED","maturityDate","notionalPrincipal",
                                  "rateSpread","description")]
    
    output$portfolioDF <- renderDataTable(portfolioDF,
                                          options = list(autoWidth = TRUE, scrollX = TRUE))
    
    #create eventSeries for the selected contract
    if(input$rfScenario == "decreasing Rates"){
      plotlist <- reactive(simulatePortfolio(ptf, serverURL, list(rfx_falling),
                                             rfx_falling$riskFactorID))
    }
    
    if(input$rfScenario == "increasing Rates"){
      plotlist <- reactive(simulatePortfolio(ptf, serverURL, list(rfx_rising),
                                             rfx_rising$riskFactorID))
    }
    if(input$rfScenario == "steady Rates"){
      plotlist <- reactive(simulatePortfolio(ptf, serverURL, list(rfx_steady),
                                             rfx_rising$riskFactorID))
    }
    if(input$rfScenario == "recovering Rates"){
      plotlist <- reactive(simulatePortfolio(ptf, serverURL, 
                                             list(rfx_recovering),
                                             rfx_rising$riskFactorID))
    }
    
    output$CFPlot <- renderPlot({
      plotlist()[[input$analysisType]]
    })
    
  })   #observe close
  
  observe({
    if(is.null(input$uploadedFile) != TRUE){
      file <- reactive(input$uploadedFile)
      cdfn_u <- file()$datapath
      rfdfn <- system.file("extdata","RiskFactors.csv",package = "FEMSdevBase")
      
      portfolioDF_u <- read.csv(cdfn_u)
      portfolioDF_u <- portfolioDF_u[,c("contractType","statusDate","contractRole","contractID",
                                        "nominalInterestRate","currency","initialExchangeDate",
                                        "premiumDiscountAtIED","maturityDate","notionalPrincipal",
                                        "rateSpread","description")]
      
      output$portfolioDF_u <- renderDataTable(portfolioDF_u,
                                              options = list(autoWidth = TRUE, scrollX = TRUE))
      
      
      #create the portfolio with the respective files
      ptf1   <-  samplePortfolio(cdfn_u,rfdfn)
      
      
      #create eventSeries for the selected contract
      if(input$rfScenarioCus == "decreasing Rates"){
        plotlistCus <- reactive(simulatePortfolio(ptf1, serverURL, list(rfx_falling),
                                                  rfx_falling$riskFactorID))
      }
      
      if(input$rfScenarioCus == "increasing Rates"){
        plotlistCus <- reactive(simulatePortfolio(ptf1, serverURL, list(rfx_rising),
                                                  rfx_rising$riskFactorID))
      }
      if(input$rfScenarioCus == "steady Rates"){
        plotlistCus <- reactive(simulatePortfolio(ptf1, serverURL, list(rfx_steady),
                                                  rfx_rising$riskFactorID))
      }
      if(input$rfScenarioCus == "recovering Rates"){
        plotlistCus <- reactive(simulatePortfolio(ptf1, serverURL, 
                                                  list(rfx_recovering),
                                                  rfx_rising$riskFactorID))
      }
      
      output$CFPlotCus <- renderPlot({
        plotlistCus()[[input$analysisTypeCus]]
      })
      
      output$warning <- renderText("")
    }
    else if(is.null(input$uploadedFile) == TRUE){
      output$warning <- renderText("No File uploaded yet")
    }
    
  })   #observe close
  
}      #server close
