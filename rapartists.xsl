<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0"
     xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

   <xsl:output method="html"
      doctype-system="about:legacy-compat"
      encoding="UTF-8"
      indent="yes" />

   <xsl:template match="/">
    <html>
        <head>
            <title>Hip-Hop Artist Contact Manager</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
            <link href="rapartists.css"
            rel="stylesheet" type="text/css" />
        </head>
        <body>
          <div class="container">
            <div class="row">
              <h1 class="center-text">Rapper Contact Manager</h1>
              <h4 class="center-text">By Nathanael Paulemon</h4>
            </div>
            <div class="row">
              <div class="col-md-12">
                <xsl:for-each select="artists/artist">
                  <xsl:sort select="name"/>
                  <div id="card">
                    <h3 class="center-text"><xsl:value-of select="name"/></h3>
                    <img class="img-responsive">
                      <xsl:attribute name="src">
                        <xsl:value-of select="imgUrl"/>
                      </xsl:attribute>
                    </img>
                    <p class="center-text"><xsl:value-of select="phone"/></p>
                    <p class="center-text"><xsl:value-of select="recordLabel"/></p>
                  </div>
                 </xsl:for-each>
              </div>
            </div>
          </div>
        </body>
    </html>
   </xsl:template>

</xsl:stylesheet>