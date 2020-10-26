import requests

f = open("../symbols.txt", "r")
symbols = f.read().split("\n")

for symbol in symbols:

    print("Fetching data for " + symbol)

    url = """https://query1.finance.yahoo.com/v7/finance/download/{}?period1=345427200&period2=1603670400&interval=1d&events=history&includeAdjustedClose=true""".format(symbol)

    r = requests.get(url, allow_redirects=True)

    print(r.url)

    open('../HistoricalStockData/{}.csv'.format(symbol), 'wb').write(r.content)
