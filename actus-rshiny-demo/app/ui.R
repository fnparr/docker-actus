# Define UI for application that visualizes cashflows for a exmaple bond
ui <- fluidPage(
  theme = shinytheme("cerulean"),
  
  #top images 
  img(src = "actus-logo.png", height = 77, width = 220,
      style="float:right; padding-right:25px"),
  img(src="Logo_Weiss.png",height = 80, width = 100),
  
  # Title and bar with tabs
  navbarPage("DaDFiR3 Demo",   #navbar App title
             tabPanel("Interest Rate Scenarios", #first Tab title
                      sidebarLayout(
                        #dataset choice input
                        selectInput(inputId = "dataSetName",
                                    label = "Choose a Dataset", 
                                    choices = c("Steady Rates", 
                                                "Increasing Rates",
                                                "Decreasing Rates", 
                                                "Recovering Rates")),
                        #output plot of the respective rate scenario
                        mainPanel( plotOutput("ratesPlot")
                        )  #main panel close
                      )  #sidebar close
             ),  #tabpanel close
             #second tabpanel Loan Contract Cashflow
             tabPanel("Loan Contract Cashflow",
                      sidebarLayout(
                        sidebarPanel(width = 3,
                                     #inputs for Loan Contract Terms
                                     selectInput(inputId = "contractType",
                                                 label = "Loan contract type",
                                                 choices = c("PAM","ANN"),
                                                 selected = "PAM"
                                     ),
                                     dateInput(inputId = "issueDate", 
                                               label = "Choose Issuedate",
                                               value = "2020-12-31"
                                     ),
                                     sliderInput(inputId = "maturity",
                                                 label = "Choose maturity",
                                                 min = 1,max = 10,
                                                 value = 5,
                                                 step = 1
                                     ),
                                     numericInput(inputId = "nominal",
                                                  label = "Set loan amount",
                                                  value = 10000,min = 0, 
                                                  max = 10000000, step = 1000
                                     ),
                                     numericInput(inputId = "coupon",
                                                  label = "Interest rate",
                                                  value = 0.02,min = 0,max = 0.05,
                                                  step = 0.005
                                     ),
                                     selectInput(inputId = "paymentFreq",
                                                 label = "Payment frequency",
                                                 choices = c("3 months", "6 months", "1 year")
                                     ),
                                     selectInput(inputId = "rateResetFreq",
                                                 label = "Rate reset frequency",
                                                 choices = c("Fixed rate","1 month", 
                                                             "3 months", "6 months",
                                                             "1 year" ) 
                                     ),
                                     numericInput(inputId = "rateResetSpread",
                                                  label = "Rate reset spread",
                                                  value = 0.05, min = 0, max = 0.05,
                                                  step = 0.005
                                     ),
                                     selectInput(inputId = "rfScenarioBond", 
                                                 label = "Interest rate scenario",
                                                 choices = c("increasing Rates",
                                                             "decreasing Rates",
                                                             "steady Rates",
                                                             "recovering Rates")
                                     )
                        ),   #sidebar panel close
                        
                        # Show a plot of the generated cashflows
                        mainPanel(width = 8,
                                  shinycssloaders::withSpinner(
                                    plotOutput("cashFlowPlot", 
                                               width = "800px",
                                               height="500px")
                                  ),     #spinnerclose,
                                  dataTableOutput("CFDF")
                        )    #main panel close
                      ) #sidebar close
             ),   #tabpanel close
             #inputs for the modelbank
             tabPanel("Portfolio Analysis",
                      sidebarLayout(
                        sidebarPanel(width = 3,
                                     selectInput("ptfFile","Choose your Portfolio",
                                                 choices = c("BondPortfolio",
                                                             "MortgagePortfolio"),
                                                 selected = "BondPortfolio"
                                     ),
                                     selectInput(
                                       inputId = "analysisType",
                                       label = "Choose the analysis type",
                                       choices =  c("monthly income",
                                                    "cumulative income",
                                                    "monthly liquidity change",
                                                    "accumulated liquidity")
                                     ),
                                     selectInput(
                                       inputId = "rfScenario",
                                       label = "Choose the Risk Factor Scenario",
                                       choices = c("increasing Rates",
                                                   "decreasing Rates",
                                                   "steady Rates",
                                                   "recovering Rates")
                                     )
                        ),   #sidebarpanel Close
                        
                        mainPanel(width = 8 ,shinycssloaders::withSpinner(
                          plotOutput("CFPlot")
                        ),   #spinner close
                        column(
                          dataTableOutput("portfolioDF"),
                          width = 12) #column close
                        )   #main panel close
                      )   #sidebarLayout close
                      
             ),   #tab panel close
             tabPanel("Uploaded Portfolio Analysis",
                      sidebarLayout(
                        sidebarPanel(width = 3,
                                     fileInput(inputId = "uploadedFile",
                                               label = "Your csv file of ACTUS PAM Contracts",
                                               accept = ".csv",
                                               buttonLabel = "Browse...",
                                               placeholder = "No file selected"
                                     ),
                                     selectInput(
                                       inputId = "analysisTypeCus",
                                       label = "Choose the analysis type",
                                       choices =  c("monthly income",
                                                    "cumulative income",
                                                    "monthly liquidity change",
                                                    "accumulated liquidity")
                                     ),
                                     selectInput(
                                       inputId = "rfScenarioCus",
                                       label = "Choose the Risk Factor Scenario",
                                       choices = c("increasing Rates",
                                                   "decreasing Rates",
                                                   "steady Rates",
                                                   "recovering Rates")
                                     )
                        ),#sidebarpanel close
                        mainPanel(
                          textOutput("warning"),
                          tags$head(tags$style("#warning{color: red;
                                 font-size: 15px;
                                 font-style: bold;
                                 }"
                          )),
                          plotOutput("CFPlotCus"),
                          column(
                            dataTableOutput("portfolioDF_u"),
                            width = 12)#column close
                        )  #mainPanel close
                      )  #sidebarlayout close
             ),  #tab panel close
             tabPanel("Help",
                      mainPanel(
                        h2("Interest Rate Scenarios"),
                        h4("In this tab you can view the four predefined interest rate scenarios. 
                             Please note that these scenarios are simple linear projections. 
                             We aim to include the posibility to upload your own risk factor scenarios.", style ="color:black"),
                        h2("Loan Contract Cashflow"),
                        h4("In this tab one can specify the terms for a single ACTUS loan contract. 
                             A cashflow plot and an event list for the specific contract is then generated.", style ="color:black"),
                        h4("ANN = Mortgage / PAM = Bond", style = "color:black"),
                        h2("Portfolio Analysis"),
                        h4("In this tab one can carry out analytics on predefined Portfolios. Income and liquidity metrics are 
                          shown in the plot and the respective contracts of the portfolio are displayed in the DataTable", style ="color:black"),
                        h2("Uploaded Portfolio Analysis"),
                        h4("You can upload a data file from your workstation specifying a portfolio 
                                        of loan contracts and request ACTUS contract simulation and analysis.",
                           "The uploaded file must be .csv format and patterned on files:",
                           tags$a("BondPortfolio.csv", 
                                  href="https://github.com/fnparr/FEMSdevBase/tree/main/inst/extdata/BondPortfolio.csv", target = "_blank"),
                           ",  and ",
                           tags$a("AnnuityPortfolio.csv", 
                                  href="https://github.com/fnparr/FEMSdevBase/tree/main/inst/extdata/AnnuityPortfolio.csv", target = "_blank"),
                           " - with any variable rate setting based on Market Object Code YC_EA_AAA.",
                           "For a more detailed explanation of each contract term, consult the ",
                           tags$a("ACTUS Data Dictionary",     href="https://www.actusfrf.org/dictionary", target = "_blank"), style ="color:black"),
                        h2("Contact"),
                        h4("Please note that this App is a Work in Progress. 
                             If you encounter any error messages or other malfunctions, 
                             please contact the developers via:", style ="color:black"),h4("info@dadfir3.ch",  style ="color:blue"),
                        h4("If you have any suggestions for new features or improvments
                             of the app, we appreciate your inputs.",style ="color:black")
                      ) #main panel close
                      
             )  #tab panel close
  )   #navbarPAGE close
)   #fluid Page close
