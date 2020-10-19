import requests

f = open("../symbols.txt", "r")
symbols = f.read().split("\n")

for symbol in symbols:
    url = """https://query1.finance.yahoo.com/v7/finance/download/
                {}?period1=345427200&period2=1602979200&interval=1d&events=history&includeAdjustedClose=true""".format(symbol)

    r = requests.get(url, allow_redirects=True)
    open('./HistoricalStockData/{}.csv'.format(symbol), 'wb').write(r.content)