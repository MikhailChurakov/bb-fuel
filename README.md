# bb-fuel

[![build_status](https://travis-ci.com/Backbase/bb-fuel.svg?branch=master)](https://travis-ci.com/Backbase/bb-fuel)

## Description
bb-fuel is a Backbase DBS data loader tool for test and demo data. It can ingest the following:
- Legal entities
- Service agreements
- Users
- Function groups
- Data groups
- Permissions
- Products
- Arrangements
- Transactions
- Approvals
- Contacts
- Payments
- Notifications
- Messages
- Actions
- Bill Pay

It is based on REST and relies on DBS service specs.

BB-Fuel supports the following environments:
- Local (based on start.backbase.com)
- AWS (default)
- PCF

## Data setup (read before running)
- [Base setup](docs/BASE_SETUP.md)
- [Capability data setup](docs/CAPABILITY_DATA_SETUP.md)

## How to run bb-fuel
All builds can be found [here](https://github.com/backbase/bb-fuel/releases)

1. Prerequisites:
- Environment should be based on one of these configurations: 
-- [application.yml](src/main/resources/application.yml)
-- [application-local.yml](src/main/resources/application-local.yml)
-- [application-pcf.yml](src/main/resources/application-pcf.yml)
Note: Alter the properties accordingly to your environment (each property can be set via command line or build the project with your custom properties with `mvn clean package`)
- Environment should contain at least the Entitlements and ProductSummary capabilities.

2. Run bb-fuel as follows:
- For environments based on AWS (default):
```
java -Denvironment.name=your-env-00 -jar bb-fuel-{version}-boot.jar
```
Note: replace `your-env-00` with the name of your environment.
Alternatively you can add `environment.name` property to `application.yml` before building bb-fuel. 

- For environments based on local:
```
java -Dspring.profiles.active=local -jar bb-fuel-{version}-boot.jar
```

- For environments based on PCF:
```
java -Dspring.profiles.active=pcf -Dpcf.space=NAME_OF_YOUR_SPACE -jar bb-fuel-{version}-boot.jar

```
Note: replace `NAME_OF_YOUR_SPACE` with the name of your space in PCF. It requires your routes to include the space name like: http://${service}-${space}.${domain}
Alternatively you can add `pcf.space` property to `application-pcf.yml` before building bb-fuel.

## Properties for ingesting data
The following properties can be set to custom values for different purposes: [data.properties](src/main/resources/data.properties)

Example:
```
java -Denvironment.name=your-env-00 -Dingest.transactions=true -Dtransactions.min=20 -Dtransactions.max=50 -jar bb-fuel-{version}-boot.jar
```

### Health check
Note: By default disabled
There is a built-in health check available to check whether services are up and running before ingesting. Available for:
- Access control
- Product summary
- Transactions

Set the value of the following property greater than 0 and it will check for that amount of minutes max.

Example:
```
healthcheck.timeout.in.minutes=10
```

### Note when running on environments with existing data
- No data will be removed from the environment
- It will check whether the following already exist, and if so, it will skip ingesting the existing item
    - Legal entities
    - Users
    - Products
- In case of existing users and service agreements: it will try to re-use function groups based on function name and service agreement combination
- When an existing function group is found, be aware that the privileges of the existing function group will remain in tact
- All other items will be added on top of the existing data
- However, if the external id of the existing root legal entity is not equal to `C000000`, this will fail the ingestion

## Custom data
See [Custom data](docs/CUSTOM_DATA.md)

## Versions
bb-fuel supports multiple DBS versions. See below which version maps to the required DBS version.

| DBS version | bb-fuel minimal [version](https://github.com/backbase/bb-fuel/releases) |
|-------------|-------------------------------------------------------------------------|
| 2.16.2      | 2.3.19                                                                  |
| 2.16.1      | 2.3.18                                                                  |
| 2.16.0      | 2.3.12                                                                  |
| 2.15.1      | 2.3.1                                                                   |
| 2.15.0      | 2.3.0+                                                                  |
| 2.14.2      | 2.2.0+                                                                  |
| 2.14.1      | 1.8.20 & 2.0.5+                                                         |
| 2.14.0      | 1.8.17+                                                                 |
| 2.13.2      | 1.8.8+                                                                  |
| 2.13.1      | 1.6.0+                                                                  |
| 2.13.0      | 1.6.0+                                                                  |
| 2.12.2      | 1.4.11+                                                                 |
| 2.12.1      | 1.4.5+                                                                  |
| 2.12.0      | 1.3.6+                                                                  |
| 2.11.2      | 1.3.5+                                                                  |
| 2.11.1      | 1.1.0+                                                                  |
| 2.11.0      | 1.0.5+                                                                  |
| 2.10.4      | [2.10.4 tag](https://github.com/backbase/bb-fuel/releases/tag/2.10.4/)  |
| 2.10.3      | [2.10.3 tag](https://github.com/backbase/bb-fuel/releases/tag/2.10.3)   |
| 2.10.2      | [2.10.2 tag](https://github.com/backbase/bb-fuel/releases/tag/2.10.2)   |
| 2.10.1      | [2.10.1 tag](https://github.com/backbase/bb-fuel/releases/tag/2.10.1)   |
| 2.10.0      | [2.10.0 tag](https://github.com/backbase/bb-fuel/releases/tag/2.10.0)   |

Note: Starting version 2.0 PCF is added as supported platform.

## Contributing
You are welcome to provide bug fixes and new features in the form of pull requests. If you'd like to contribute, please be mindful of the following guidelines:

- All changes should be tested on a [Blade](https://start.backbase.com/) environment (or a similar environment setup) based on the latest versions.
- Please make one change/feature per pull request.
- Use descriptive commit messages which will be used for release notes.
- Try to avoid reformat of files that change the indentation, tabs to spaces etc., as this makes reviewing diffs much more difficult.

## Contributors
- [Kwo Ding](https://github.com/kwoding) (author)
- [Mark Bertels](marinus@backbase.com)
- [Richard Blank](richardb@backbase.com)
- [Pim Hazebroek](pimh@backbase.com)

# License
Copyright (c) 2019 Backbase B.V.

This Backbase License Agreement (“Agreement”) sets forth the terms and conditions of Your use of the Software that is provided together with this license. If You continue to download the Software, You agree that Your use of the Software, and the use of the Software by any natural or legal person you distribute the Software to, will be covered by this license Agreement. Any third party software that is provided with the Software is included for use at Your option subject to the terms of the license applicable to that software. If You choose to use such software, then such use shall be governed by such third party's license agreement (See Annex A to these terms for an overview of third party software) and not by this Agreement.

1. Definitions

1.1 “Backbase” shall mean Backbase Europe BV, whose place of business is at the INIT Building, Jacob Bontiusplaats 9, 1018 LL Amsterdam, The Netherlands.

1.2 “Documentation” means all online help files or written instruction manuals regarding the Software.

1.3 “Derivative Works” shall mean any Software, whether in source or object form, that is based on (or derived from) the Software and for which the editorial revisions, annotations, elaborations, or other modifications represent, as a whole, an original work of authorship.

1.4 “Licensee” or “You” means the individual who downloads the Software and, if you are downloading the Software to be used for or on behalf of a legal entity, the entity on behalf of which you are downloading the Software.

1.5 “Software” means the object code of the computer program(s) Licensee has downloaded and includes any Documentation as provided.

2. Grant of Rights and Restrictions

2.1 License Grant. Backbase grants to Licensee a non-exclusive, non-transferable right and license to: (a) reproduce, modify and prepare Derivative Works of the Software, and (b) use the Software and Derivative Works for its own internal use and, subject to the conditions in section 2.2, distribute the Software and such Derivative Works as an integrated part of commercial products that Licensee makes available on the market (e.g. mobile apps). Any other form of distribution or reselling the Software is not permitted. Except for the express license granted in this Section 2.1, no other licenses are granted.

2.2 Redistribution. Licensee may distribute the Software and such Derivative Works as an integrated part of commercial products Licensee makes available on the market, provided that Licensee meets the following conditions:

a) Licensee must provide any other recipients to whom it distributes the Software or Derivative Works to, with reasonable notice of these terms and the applicability thereof to the use of the Software. Moreover, Licensee shall require such recipients to agree to the terms of this Agreement including its annexes before making the Software available for download; and
b) Licensee must retain in the Software and Derivative Works any “NOTICE” text files (where such notices normally appear) and all copyright, patent, and trademark notices excluding those notices that do not pertain to any part of the Derivative Works. Contents of the NOTICE file are for informational purposes only and do not modify the License.

c) This License does not grant any rights in the patents, trademarks, service marks, or logos of Backbase (except as may be necessary to comply with the notice requirements in Section 2.2).

3. Warranty Disclaimer and Limitation of Liability

THE SOFTWARE IS PROVIDED ON AN "AS IS", ‘WHERE IS” BASIS, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION ANY WARRANTIES THAT THE SOFTWARE IS FREE OF DEFECTS, MERCHANTABLE, FIT FOR A PARTICULAR PURPOSE OR NON-INFRINGING. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE SOFTWARE IS BORNE BY LICENSEE. IN NO EVENT SHALL BACKBASE BE LIABLE, NOR SHALL LICENSEE HOLD BACKBASE LIABLE, FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, ARISING FROM THE USE OR DISTRIBUTION OF THE SOFTWARE. THIS SECTION 3 CONSTITUTES AN ESSENTIAL PART OF THIS AGREEMENT. THE SOFTWARE MAY NOT BE USED HEREUNDER EXCEPT UNDER THIS DISCLAIMER AND LIMITATION OF LIABILITY.

4. Indemnification by Licensee

Licensee shall defend, indemnify and hold harmless Backbase and its officers, directors, employees and shareholders from and against any and all loss, damage, settlement, costs or expense (including legal expenses and expenses of other professionals), as incurred, resulting from, or arising out of any third party claim which alleges that a Derivative Work infringes upon, misappropriates or violates any intellectual property rights, where such claim is independent of the Software.

5. Applicable Law and Jurisdiction

This Agreement is governed by and interpreted in accordance with the laws of the Netherlands, and Licensee hereby consents to the exclusive jurisdiction and venue of the District Court of Amsterdam.
