import requests
from datetime import date, datetime, timedelta
import pandas as pd
import psycopg2

# This script is a cron job that runs nightly at midnight.

conn = psycopg2.connect(
    host="localhost",
    database="stockvisualizerdb",
    user="postgres",
    password="a"
)
cur = conn.cursor()

def get_epochs():
    today = datetime.combine(date.today(), datetime.min.time()) - timedelta(hours = 4)
    tomorrow = today + timedelta(hours = 24)

    today_epoch = int(today.timestamp())
    tomorrow_epoch = int(tomorrow.timestamp())

    return [today_epoch, tomorrow_epoch]

def fetch_data():
    f = open("/home/msokol/Projects/stockvisualizer/api/src/main/resources/symbols.txt", "r")
    symbols = f.read().split("\n")

    epochs = get_epochs()
    today = epochs[0]
    tomorrow = epochs[1]

    data = []

    for symbol in symbols:
        url = "https://query1.finance.yahoo.com/v7/finance/download/{}?period1={}&period2={}&interval=1d&events=history&includeAdjustedClose=true".format(symbol, today, tomorrow)

        r = requests.get(url, allow_redirects=True)
        content = r.content.splitlines()

        if 1 < len(content): 
            content = content[1].decode("utf-8").split(",")

            # Date, Open, High, Low, Close, Adj Close, Volume
            date = content[0]
            opening = content[1]
            high = content[2]
            low = content[3]
            close = content[4]
            volume = content[6]

            print([symbol, date, opening, high, low, close, volume])

            data.append([symbol, date, opening, high, low, close, volume])
    
    return data

sql = "select id from stock_day order by id desc limit 1;"
cur.execute(sql)
id = cur.fetchone()[0] + 1

def persist(stock_data):

    for data in stock_data:
            symbol = data[0]
            date = data[1]
            opening = data[2]
            high = data[3]
            low = data[4]
            close = data[5]
            volume = data[6]

            global id
            id += 1

            print((id, symbol, date, opening, high, low, close, volume))

            cur.execute("INSERT INTO stock_day(id, close, date, high, low, open, volume, stock_symbol) values(%s, %s, %s, %s, %s, %s, %s, %s)",
                (id, close, date, high, low, opening, volume, symbol))


    conn.commit()
    print("Committed to database.")
    cur.close()
    conn.close()

def main():
    todays_stock_data = fetch_data()
    persist(todays_stock_data)


main()
