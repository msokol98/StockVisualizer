import requests
import psycopg2

conn = psycopg2.connect(
    host="localhost",
    database="stockvisualizerdb",
    user="postgres",
    password="a"
)
cur = conn.cursor()

f = open("../symbols.txt", "r")
symbols = f.read().split("\n")

for symbol in symbols:

    cur.execute("SELECT name FROM Company WHERE symbol = %s", (symbol, ))
    res = cur.fetchone()
    if res != (None, ):
        continue

    print("Fetching data for " + symbol)

    url = "https://financialmodelingprep.com/api/v3/profile/{}?apikey=42f0a5e1a644c2dd580577a88745792a".format(symbol)
    r = requests.get(url, allow_redirects=True)

    response = r.json()

    if (type(response).__name__) != 'list':
        continue;

    company_profile = r.json()[0]

    cur.execute("""UPDATE Company SET
            symbol = %s,
            name = %s,
            exchange = %s,
            industry = %s,
            website = %s,
            description = %s,
            ceo = %s,
            sector = %s,
            no_employees = %s,
            country = %s,
            phone = %s,
            address = %s,
            city = %s,
            state = %s,
            zip = %s,
            image = %s,
            ipo_date = %s
            WHERE symbol = %s""",
        (
            company_profile['symbol'],
            company_profile['companyName'],
            company_profile['exchange'],
            company_profile['industry'],
            company_profile['website'],
            company_profile['description'],
            company_profile['ceo'],
            company_profile['sector'],
            company_profile['fullTimeEmployees'],
            company_profile['country'],
            company_profile['phone'],
            company_profile['address'],
            company_profile['city'],
            company_profile['state'],
            company_profile['zip'],
            company_profile['image'],
            company_profile['ipoDate'],
            company_profile['symbol']
        ))




conn.commit()
cur.close()
conn.close()