#!/usr/bin/bash

npm run build && systemctl restart nginx && echo "Web server was restarted"
