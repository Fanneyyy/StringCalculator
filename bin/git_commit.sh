#!/bin/bash
echo -e "Please enter the commit message: \c "
read
echo "---- Adding files ----"
git add .
echo "---- Committing files ----"
git commit -a -m "$REPLY"