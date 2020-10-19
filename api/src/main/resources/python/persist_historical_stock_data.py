import pandas as pd
import psycopg2

conn = psycopg2.connect(
    host="localhost",
    database="stockvisualizerdb",
    user="postgres",
    password="a"
)
cur = conn.cursor()

def parse_stock_data(symbol):
    csv_data = '../HistoricalStockData/{}.csv'.format(symbol)
    df = pd.read_csv(csv_data)

    stock_data = []

    for row in df.iterrows():
        data = row[1]

        stock_data.append({
                "date": data[0],
                "open": data[1],
                "high": data[2],
                "low": data[3],
                "close": data[4],
                "volume": data[6]
            })

    return stock_data
        

id = 0

def persist_stock_day_data(symbol, data):
    date = data['date']
    opening = data['open']
    close = data['close']
    high = data['high']
    low = data['low']
    volume = data['volume']

    global id
    id += 1

    print((id, close, date, high, low, opening, volume, symbol))

    cur.execute("INSERT INTO stock_day(id, close, date, high, low, open, volume, stock_symbol) values(%s, %s, %s, %s, %s, %s, %s, %s)",
       (id, close, date, high, low, opening, volume, symbol))

    

def persist_company_stock_data(symbol):
    cumulative_stock_data = parse_stock_data(symbol)

    for stock_data in cumulative_stock_data:
        persist_stock_day_data(symbol, stock_data)


f = open("../symbols.txt", "r")
symbols = f.read().split("\n")

for symbol in symbols:
    persist_company_stock_data(symbol)

conn.commit()   
cur.close()
conn.close()